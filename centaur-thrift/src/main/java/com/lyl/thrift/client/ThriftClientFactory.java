package com.lyl.thrift.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lyl
 * Date 2019/1/8 16:12
 */
public class ThriftClientFactory {
    private final static Logger LOGGER = LogManager.getLogger(ThriftClientFactory.class);

    private static volatile Map<String, DynamicThriftClientProxy> thriftRpcProxies = new ConcurrentHashMap<>();
    public static <T> T updateThriftClient(Class<T> ifaceClazz, ServerInfo[] servers) {
        DynamicThriftClientProxy<T> dynamicThriftClientProxy = new DynamicThriftClientProxy(ifaceClazz, servers);
        thriftRpcProxies.put(ifaceClazz.getName(), dynamicThriftClientProxy);
        return (T)dynamicThriftClientProxy.getProxy();
    }

    public static <T> T updateNonBlockingThriftClient(Class<T> ifaceClazz, ServerInfo[] servers) {
        DynamicThriftClientProxy<T> dynamicThriftClientProxy = new DynamicThriftClientProxy(
                ifaceClazz, TBinaryProtocol.class, TFramedTransport.class, servers, null);
        thriftRpcProxies.put(ifaceClazz.getName(), dynamicThriftClientProxy);
        return (T)dynamicThriftClientProxy.getProxy();
    }

    public static <T> T getThriftClient(Class<T> ifaceClazz, ServerInfo[] servers) {
        return getThriftClient(ifaceClazz, TBinaryProtocol.class, servers, 1);
    }

    public static <T> T getThriftClient(Class<T> ifaceClazz, ServerInfo[] servers,int retryCount) {
        return getThriftClient(ifaceClazz, TBinaryProtocol.class, servers, retryCount);
    }

    static Object getThriftClient(String clazzName, ServerInfo[] servers) {
        try {
            return getThriftClient(Class.forName(clazzName), TBinaryProtocol.class, servers, 1);
        } catch (ClassNotFoundException cnf) {
            LOGGER.error("getThriftRpcProxy failed due to class not found:", cnf);
            return null;
        }
    }

    public static <T, P> T getThriftClient(Class<T> ifaceClz, Class<P> protocolClz, ServerInfo[] servers, int retryCount) {
        try {
            String clazzName = ifaceClz.getName();
            T result;
            DynamicThriftClientProxy clientProxy = thriftRpcProxies.get(clazzName);
            if (clientProxy == null) {
                synchronized (thriftRpcProxies) {
                    clientProxy = thriftRpcProxies.get(clazzName);
                    if (clientProxy == null) {
                        DynamicThriftClientProxy<T> dynamicThriftClientProxy
                                = new DynamicThriftClientProxy(ifaceClz, protocolClz,
                                servers, new RoundRobinStrategy(servers,retryCount));
                        thriftRpcProxies.put(clazzName, dynamicThriftClientProxy);
                    }
                }
            }
            result = (T) thriftRpcProxies.get(clazzName).getProxy();
            return result;
        } catch (Throwable t) {
            LOGGER.error("getThriftRpcProxy failed:", t);
            return null;
        }
    }

    public static <T> T getNonBlockingThriftClient(Class<T> clientClass, ServerInfo[] servers) {
        return getNonBlockingThriftClient(clientClass, servers, null);
    }

    public static <T> T getNonBlockingLoalPriorityThriftClient(Class<T> clientClass, ServerInfo[] servers) {
        return getNonBlockingThriftClient(clientClass, servers, new RoundRobinLocalPriorityStrategy(servers, 1));
    }


    public static <T> T getNonBlockingThriftClient(Class<T> clientClass, ServerInfo[] servers, ServerSelectionStrategy strategy) {
        try {
            String clazzName = clientClass.getName();
            T result;
            DynamicThriftClientProxy clientProxy = thriftRpcProxies.get(clazzName);
            if (clientProxy == null) {
                synchronized (thriftRpcProxies) {
                    clientProxy = thriftRpcProxies.get(clazzName);
                    if (clientProxy == null) {
                        if(strategy == null) {
                            strategy = new RoundRobinStrategy(servers, 1);
                        }
                        DynamicThriftClientProxy<T> dynamicThriftClientProxy = new DynamicThriftClientProxy(
                                clientClass, TBinaryProtocol.class, TFramedTransport.class, servers, strategy);
                        thriftRpcProxies.put(clazzName, dynamicThriftClientProxy);
                    }
                }
            }
            result = (T) thriftRpcProxies.get(clazzName).getProxy();
            return result;
        } catch (Throwable t) {
            LOGGER.error("getThriftRpcProxy failed:", t);
            return null;
        }
    }
}
