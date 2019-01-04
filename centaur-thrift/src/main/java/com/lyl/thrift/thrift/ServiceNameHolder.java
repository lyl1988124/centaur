package com.lyl.thrift.thrift;

/**
 * Created by lyl
 * Date 2019/1/2 20:18
 */
public class ServiceNameHolder {

    private ServiceNameHolder() {
    }

    private static volatile String currentServiceName = "";

    /**
     * 注册服务名
     */
    public static void registerServiceName(String serviceName) {

        if (currentServiceName.equals("")) {
            currentServiceName = serviceName;
        }
    }

    /**
     * 获取当前服务名
     */
    public static String getCurrentServiceName() {
        return currentServiceName;
    }
}
