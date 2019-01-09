package com.lyl.thrift.server;

import java.lang.annotation.*;

/**
 * Created by lyl
 * Date 2019/1/2 20:20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportableThriftService {
    /**
     * 支持的协议
     */
    ThriftProtocol protocol() default ThriftProtocol.BINARY;

    /**
     * 是否强制签名检验
     */
    boolean forceSignature() default false;
}
