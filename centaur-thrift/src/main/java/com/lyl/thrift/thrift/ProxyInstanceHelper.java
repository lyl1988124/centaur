package com.lyl.thrift.thrift;

import java.lang.reflect.Method;

/**
 * Created by lyl
 * Date 2019/1/3 18:05
 */
public class ProxyInstanceHelper {


    private static final Method TOSTRING_METHOD;

    static {
        try {
            TOSTRING_METHOD = Object.class.getMethod("toString");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isToStringMethod(Method method) {
        return TOSTRING_METHOD.equals(method);
    }

}
