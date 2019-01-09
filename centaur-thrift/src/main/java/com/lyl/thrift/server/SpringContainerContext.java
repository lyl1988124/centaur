package com.lyl.thrift.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lyl
 * Date 2019/1/2 19:48
 */
public class SpringContainerContext implements ContainerContext{

    private static final Logger LOGGER = LogManager.getLogger(SpringContainerContext.class);
    private final ApplicationContext applicationContext;

    public SpringContainerContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        try {
            return applicationContext.getBean(beanClass);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return this.applicationContext.getBean(beanName,beanClass);
    }

    @Override
    public List<Object> getBeansWithExportableAnnotation(Class<? extends Annotation> annotationClass) {
        List<Object> list = new ArrayList<>();
        try {
            Map<String,Object> map =  applicationContext.getBeansWithAnnotation(annotationClass);
            list.addAll( map.values());
            return list;
        } catch (BeansException e) {
            LOGGER.info("", e);
        }
        return list;
    }

    @Override
    public Class<?> getFinalTargetClass(Object service) {
        if(AopUtils.isAopProxy(service)) {
            return AopUtils.getTargetClass(service);
        }

        return service.getClass();
    }
}
