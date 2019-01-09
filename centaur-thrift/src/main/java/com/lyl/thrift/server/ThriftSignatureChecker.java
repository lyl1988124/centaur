package com.lyl.thrift.server;

/**
 * Created by lyl
 * Date 2019/1/2 20:24
 */
public interface ThriftSignatureChecker {
    boolean check(Object[] args,String methodName,byte[] body,String sign);
}
