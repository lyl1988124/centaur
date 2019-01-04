package com.lyl.thrift.thrift;

import com.lyl.thrift.common.Trace;

/**
 * Created by lyl
 * Date 2019/1/4 11:13
 */
public interface ThriftHeaderProvider {
    Trace provideTrace();

    String provideSignatureInfo();
}
