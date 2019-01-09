package com.lyl.thrift.server;

import com.lyl.thrift.common.Trace;

/**
 * Created by lyl
 * Date 2019/1/4 11:13
 */
public interface ThriftHeaderProvider {
    Trace provideTrace();

    String provideSignatureInfo();
}
