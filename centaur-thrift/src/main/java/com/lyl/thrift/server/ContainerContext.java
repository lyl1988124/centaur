package com.lyl.thrift.server;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by lyl
 * Date 2019/1/2 18:59
 */
public interface ContainerContext {
    /**
     * spring context
     *
     * @param beanClass
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> beanClass);

    /**
     * get bean with ExportableHttpService or ExportableThriftService annotation
     *
     * @param beanName
     * @param beanClass
     * @param <T>
     * @return
     */
    <T> T getBean(String beanName,Class<T> beanClass);
    /**
     * 同spring context
     */
    List<Object> getBeansWithExportableAnnotation(Class<? extends Annotation> annotationClass);

    /**
     * 获取aop对象的target class
     *
     * @param service
     * @return
     */
    Class<?> getFinalTargetClass(Object service);
}
