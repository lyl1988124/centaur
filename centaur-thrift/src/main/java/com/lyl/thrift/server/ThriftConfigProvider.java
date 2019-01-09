package com.lyl.thrift.server;

/**
 * Created by lyl
 * Date 2019/1/2 18:23
 */
public interface ThriftConfigProvider {
    /**
     * 超时
     */
    int getClientTimeout();

    /**
     * 最大线程数
     */
    int getMaxThreads();

    /**
     * 服务名称
     */
    String getServiceName();

    /**
     * 端口
     */
    int getPort();

    /**
     * 服务权重
     */
    int getWeight();
}
