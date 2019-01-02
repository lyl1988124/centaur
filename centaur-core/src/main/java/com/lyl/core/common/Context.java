package com.lyl.core.common;

import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * Created by lyl
 * Date 2018/12/27 16:52
 */
public class Context {
    private static ConfigurableApplicationContext ctx;

    public static void setContext(ConfigurableApplicationContext ctx){
        Context.ctx=ctx;
    }

    public static <T> T getBean(Class<T> clazz){
        return ctx.getBean(clazz);
    }

    public static <T> Map<String,T> getBeans(Class<T> clazz){
        return ctx.getBeansOfType(clazz);
    }
}
