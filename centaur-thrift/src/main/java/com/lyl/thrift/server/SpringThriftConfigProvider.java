package com.lyl.thrift.server;


import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lyl
 * Date 2019/1/2 18:17
 */
public class SpringThriftConfigProvider implements ThriftConfigProvider{

    @Value("${global.service.name:unKnown}")
    private String serviceName;

    @Value("${global.service.weight:1}")
    private int weight;

    @Value("${global.service.port:-1}")
    private int port;

    @Value("${thrift.timeout:5000}")
    private int timeout;

    @Value("${thrift.threadcount:64}")
    private int maxThreads;

    public String getServiceName() {
        return serviceName;
    }

    public int getPort() {
        if (port == -1) {
            throw new RuntimeException("you should configure server port in config file or env.");
        }
        return port;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getClientTimeout() {
        return timeout;
    }

    public int getMaxThreads() {
        return maxThreads;
    }
}
