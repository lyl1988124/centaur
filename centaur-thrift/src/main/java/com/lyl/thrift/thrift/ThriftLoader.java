package com.lyl.thrift.thrift;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.Collection;
import java.util.List;

/**
 * Created by lyl
 * Date 2018/12/28 16:25
 */
public class ThriftLoader {

    private static final Logger LOGGER = LogManager.getLogger(ThriftLoader.class);

    public ThriftLoader() {
    }


    public static void load(ContainerContext context, ThriftConfigProvider serverConfigProvider)
            throws TTransportException {
        ServiceNameHolder.registerServiceName(serverConfigProvider.getServiceName());

        LOGGER.info("start to load thrift server of {}.", serverConfigProvider.getServiceName());
        List<Object> allThriftService = context
                .getBeansWithExportableAnnotation(ExportableThriftService.class);
        if (allThriftService.size() == 0) {
            LOGGER.error("no thrift service export: {}.",
                    serverConfigProvider.getServiceName());
            throw new RuntimeException("no thrift service export.");
        }

        ThriftSignatureChecker thriftSignChecker = null;
        thriftSignChecker = context.getBean(ThriftSignatureChecker.class);

        NormalizedProcessor processor = NormalizedProcessor
                .factory(allThriftService, thriftSignChecker,context);

        TServerSocket serverTransport = new TServerSocket(serverConfigProvider.getPort(),
                serverConfigProvider.getClientTimeout());

        TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);
        args.maxWorkerThreads(serverConfigProvider.getMaxThreads());
        TProtocolFactory tProtocolFactory = recognizeProtocol(allThriftService, context);
        args.inputProtocolFactory(tProtocolFactory);
        args.outputProtocolFactory(tProtocolFactory);
        args.processor(processor);

        TThreadPoolServer server = new TThreadPoolServer(args);

        LOGGER.info("startup thrift server {} without serviceRegister.",
                serverConfigProvider.getServiceName());
        server.serve();

    }

    protected static TProtocolFactory recognizeProtocol(Collection<Object> serviceList,
                                                        ContainerContext context)
            throws RuntimeException {
        ThriftProtocol supportProtocol = null;
        for (Object service : serviceList) {
            Class<?> serviceRealClass = context.getFinalTargetClass(service);
            ExportableThriftService exportableService = serviceRealClass
                    .getAnnotation(ExportableThriftService.class);
            if (supportProtocol == null) {
                supportProtocol = exportableService.protocol();
                continue;
            }
            if (supportProtocol != exportableService.protocol()) {
                throw new RuntimeException("service support only one kind of protocol.");
            }
        }
        switch (supportProtocol) {
            case BINARY:
                return new TBinaryProtocol.Factory();
            case COMPACT:
                return new TCompactProtocol.Factory();
            case JSON:
                return new TJSONProtocol.Factory();
            case HEADER_BINARY:
                return new THeaderBinaryProtocol.ServerSideFactory();
        }
        return null;
    }

}
