package com.lyl.thrift.client;

import lombok.Data;

/**
 * Created by lyl
 * Date 2019/1/9 14:49
 */
@Data
public class ThriftServerConfig {
    private String host;
    private int port;
    private int timeOut;
}
