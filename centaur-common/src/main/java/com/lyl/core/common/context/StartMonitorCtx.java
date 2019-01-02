package com.lyl.core.common.context;

import com.lyl.core.common.enums.SupportServiceProtocol;
import lombok.Getter;

import java.lang.reflect.Method;

/**
 * Created by lyl
 * Date 2018/12/27 17:58
 */
public final class StartMonitorCtx extends CommonMonitorCtx{

    //true:生成json    生成json便于阅读，但消耗性能
    private final boolean isTrace;

    @Getter
    private final String requestJson;

    @Getter
    private final SupportServiceProtocol supportServiceProtocol;

    public StartMonitorCtx(SupportServiceProtocol supportServiceProtocol, boolean isTrace, String requestJson) {
        this.isTrace = isTrace;
        this.requestJson = requestJson;
        this.supportServiceProtocol = supportServiceProtocol;
    }

    public boolean isTrace(){
        return isTrace;
    }

    public void copyProperties(CommonMonitorCtx ctx){
        this.setMethod(ctx.getMethod());
        this.setMethodClass(ctx.getMethodClass());
        this.setMethodFullName(ctx.getMethodFullName());
        this.setServiceName(ctx.getServiceName());
        this.setCurrentServiceName(ctx.getCurrentServiceName());
    }
}
