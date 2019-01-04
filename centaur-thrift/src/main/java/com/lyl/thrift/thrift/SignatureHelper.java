package com.lyl.thrift.thrift;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by lyl
 * Date 2019/1/3 19:21
 */
public class SignatureHelper {
    private SignatureHelper (){}

    /**
     * md5 签名
     */
    public static String md5Signature(byte[] body) {
        return "MD5:" + DigestUtils.md5Hex(body);
    }
}
