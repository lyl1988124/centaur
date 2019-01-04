package com.lyl.thrift.thrift;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyl
 * Date 2019/1/3 16:22
 */
public class NormalizedProcessor implements TProcessor {
    private static final Logger LOGGER = LogManager.getLogger(NormalizedProcessor.class);

    private static final String INTERFACE_NAME = "$Iface";
    private static final String PROCESSOR_NAME = "$Processor";

    private final Map<String,ThriftMethod> methodMap;

    private NormalizedProcessor(Map<String,ThriftMethod> processorMap){
        this.methodMap=processorMap;
    }

    public static NormalizedProcessor factory(Collection<Object> serviceList,
                                              ThriftSignatureChecker thriftSignChecker,
                                              ContainerContext context) {
        Map<String, ThriftMethod> processorMap = new HashMap<>();
        Map<String, ThriftMethod> unmodifiableMap = Collections.unmodifiableMap(processorMap);

        boolean needSignature = false;
        for (Object service : serviceList) {
            Class<?> serviceRealClass = context.getFinalTargetClass(service);
            Class<?> interfaceClass = getInterfaceFromServiceObject(serviceRealClass);
            ExportableThriftService exportableThriftService = serviceRealClass
                    .getAnnotation(ExportableThriftService.class);
            if (interfaceClass == null) {
                throw new RuntimeException(service.getClass().getName() + " has not Iface");
            }
            TBaseProcessor tBaseProcessor = createProcessor(interfaceClass, serviceRealClass, service,
                    unmodifiableMap,
                    thriftSignChecker);
            if (tBaseProcessor == null) {
                throw new RuntimeException(service.getClass().getName() + " has not Processor");
            }
            boolean forceSignature = (exportableThriftService.forceSignature()
                    && exportableThriftService.protocol() == ThriftProtocol.HEADER_BINARY);
            needSignature = needSignature || forceSignature;

            Map<String, Method> interfaceMethodMap = collectMethod(interfaceClass,
                    serviceRealClass);
            Map<String, ProcessFunction> methodMap = tBaseProcessor
                    .getProcessMapView();
            for (Map.Entry<String, ProcessFunction> entry : methodMap.entrySet()) {
                if (processorMap.containsKey(entry.getKey())) {
                    throw new RuntimeException(entry.getKey() + " is duplicate");
                }

                Method targetInterfaceMethod = interfaceMethodMap.get(entry.getKey());

                processorMap
                        .put(entry.getKey(),
                                new ThriftMethod(tBaseProcessor, targetInterfaceMethod, serviceRealClass,
                                        interfaceClass, exportableThriftService.protocol(), forceSignature));
            }
        }

        if (needSignature && thriftSignChecker == null) {
            LOGGER.info(
                    "this server need signature feature,you should create bean of ThriftSignatureChecker.");
            throw new RuntimeException(
                    "this server need signature feature,you should create bean of ThriftSignatureChecker.");
        }

        return new NormalizedProcessor(unmodifiableMap);
    }


    /**
     * 真实对象中实现的thrift接口方法
     *
     * @param interfaceClass thrift接口
     * @param serviceClass {@link ContainerContext#getFinalTargetClass(Object)}返回的真实对象
     */
    private static Map<String, Method> collectMethod(Class<?> interfaceClass, Class<?> serviceClass) {
        Map<String, Method> methodMap = new HashMap<>();
        for (Method method : interfaceClass.getMethods()) {
            try {
                Method targetMethod = serviceClass.getMethod(method.getName(), method.getParameterTypes());
                methodMap.put(method.getName(), targetMethod);

                LOGGER.info("{}: collect method of {}.{}.", serviceClass.getName(), interfaceClass.getName(),
                                method.getName());
            } catch (NoSuchMethodException e) {
                // 不会出现
                LOGGER.info("", e);
            }
        }

        return methodMap;
    }

    /**
     * 识别thrift接口，xxxx$Iface
     */
    private static Class<?> getInterfaceFromServiceObject(final Class<?> clazz) {
        if (clazz.getAnnotation(ExportableThriftService.class) == null) {
            LOGGER.info("{} has not ExportableService annotation.", clazz.getName());
            return null;
        }

        Class<?>[] interfaceArray = clazz.getInterfaces();
        for (Class<?> interfaceClass : interfaceArray) {
            if (interfaceClass.getName().endsWith(INTERFACE_NAME)) {
                LOGGER.info("find {} from {}.", interfaceClass.getName(), clazz.getName());
                return interfaceClass;
            }
        }
        LOGGER.info("can't find {} interface from {}.", INTERFACE_NAME, clazz.getName());
        return null;
    }

    /**
     * 创建thrift编译出的Processor对象，基于xxx$Iface类名推导出Processor类名。Processor对象所最终调用的
     * xxx$Iface被代理封装，用于支持流控及调用链路监控
     */
    private static TBaseProcessor createProcessor(final Class<?> interfaceClass,
                                                  final Class<?> serviceRealClass,
                                                  final Object service, final Map<String, ThriftMethod> unmodifyMap,
                                                  final ThriftSignatureChecker thriftSignChecker) {
        String classNamePrefix = interfaceClass.getName()
                .substring(0, interfaceClass.getName().length() - INTERFACE_NAME.length());
        String processorClassName = classNamePrefix + PROCESSOR_NAME;
        try {
            LOGGER.info("load class of {} for {}.", processorClassName, interfaceClass.getName());
            Class<?> processorClass = Class.forName(processorClassName);
            Constructor<?> constructor = processorClass.getConstructor(interfaceClass);
            return
                    (TBaseProcessor) constructor
                            .newInstance(
                                    createServiceProxy(interfaceClass, serviceRealClass, service, unmodifyMap, thriftSignChecker));
        } catch (ClassNotFoundException | NoSuchMethodException
                | IllegalArgumentException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            LOGGER.info(String.format("%s class error.", processorClassName), e);
            return null;
        }
    }

    /**
     * 创建xxx$Iface代理对象，用于流控、调用线路监控
     */
    private static Object createServiceProxy(final Class<?> interfaceClass,
                                             final Class<?> serviceRealClass,
                                             final Object service, final Map<String, ThriftMethod> unmodifyMap,
                                             final ThriftSignatureChecker thriftSignChecker) {
        LOGGER.info("create service proxy of {} for {}.", interfaceClass.getName(),
                serviceRealClass.getName());
        return Proxy.newProxyInstance(NormalizedProcessor.class.getClassLoader(),
                new Class[]{interfaceClass}, (proxy, method, args) -> {

                    if (ProxyInstanceHelper.isToStringMethod(method)) {
                        return interfaceClass.getName() + ".proxy_instance_name";
                    }

                    Object retValue = null;
                    retValue = method.invoke(service, args);
                    return retValue;
                });
    }


    @Override
    public boolean process(TProtocol in, TProtocol out) throws TException {
        TProtocol inProtocol = new RepeatedBeginProtocol(in);

        TMessage msg = inProtocol.readMessageBegin();
        String callerIp = getCallerIp(in);

        ThriftMethod thriftMethod = this.methodMap.get(msg.name);
        if (thriftMethod == null) {
            LOGGER.info("service not exist:{}->{}.", callerIp, msg.name);
            TProtocolUtil.skip(in, TType.STRUCT);
            in.readMessageEnd();
            TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD,
                    "Invalid method name: '" + msg.name + "'");
            out.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
            x.write(out);
            out.writeMessageEnd();
            out.getTransport().flush();
            return true;
        }

        thriftMethod.acceptHeader(in);

        LOGGER.info("begin process {} from {}.", thriftMethod.fullMethodName, callerIp);

        try {
            thriftMethod.processor.process(inProtocol, out);
        } finally {
            thriftMethod.clearTrace();
            LOGGER.info("final process {} from {}.", thriftMethod.fullMethodName, callerIp);
        }

        return true;
    }

    private String getCallerIp(final TProtocol in) {
        TTransport transport = in.getTransport();
        if (!(transport instanceof TSocket)) {
            return null;
        }

        InetSocketAddress remoteAddress = (InetSocketAddress) ((TSocket) transport).getSocket()
                .getRemoteSocketAddress();
        return String.format("%s:%d", remoteAddress.getHostName(), remoteAddress.getPort());
    }


}
