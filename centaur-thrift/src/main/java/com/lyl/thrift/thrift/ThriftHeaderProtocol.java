package com.lyl.thrift.thrift;

import com.lyl.thrift.common.Trace;

/**
 * Created by lyl
 * Date 2019/1/3 17:06
 */
public interface ThriftHeaderProtocol {
    Trace getTrace();

    String getSignatureString();
}
