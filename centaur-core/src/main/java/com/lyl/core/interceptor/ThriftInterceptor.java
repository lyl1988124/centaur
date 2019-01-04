package com.lyl.core.interceptor;

import com.lyl.thrift.common.ReturnMsg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by lyl
 * Date 2019/1/4 17:16
 */

@Component
@Aspect
@Order(1)
public class ThriftInterceptor {
    private static final Logger LOGGER = LogManager.getLogger(ThriftInterceptor.class);

    @Value("${sign.check}")
    private boolean signCheck=false;

    @Pointcut(value = "execution(* com.lyl.thrift.*.*.Iface.*(..))")
    private void pointCut(){
        LOGGER.info("pointCut() ");
    }

    @Around( value = "pointCut()")
    public Object arroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        ReturnMsg returnMsg = null;
        LOGGER.info("aroundMethod ");
        LOGGER.info(signCheck);
        Object[] argsArray = proceedingJoinPoint.getArgs();
        try {
            returnMsg = (ReturnMsg) proceedingJoinPoint.proceed(argsArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return returnMsg;
    }

}
