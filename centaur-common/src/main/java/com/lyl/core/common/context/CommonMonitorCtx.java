package com.lyl.core.common.context;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;

/**
 * Created by lyl
 * Date 2018/12/27 17:08
 */
public class CommonMonitorCtx {

    @Getter
    @Setter
    private Method method;

    @Getter
    @Setter
    private Class<?> methodClass;

    @Getter
    @Setter
    private String methodFullName;

    @Getter
    @Setter
    private String serviceName;

    @Getter
    @Setter
    private String currentServiceName;

    public CommonMonitorCtx() {
    }

    public CommonMonitorCtx(Method method, Class<?> methodClass, String methodFullName, String currentServiceName, String serviceName) {
        this.method = method;
        this.methodClass = methodClass;
        this.methodFullName = methodFullName;
        this.currentServiceName = currentServiceName;
        this.serviceName = serviceName;
    }

    public static String uniqueMethodName(String serviceName,String methodFullName){
        return String.format("%s_%s",serviceName,methodFullName);
    }


    public String getUniqueMethodName(){
        return uniqueMethodName(serviceName,methodFullName);
    }
}

