package com.lyl.core.common.context;

import lombok.Getter;

/**
 * Created by lyl
 * Date 2018/12/27 18:13
 */
public final class EndMonitorCtx {
    private final boolean isTrace;

    @Getter
    private final String responseJson;

    @Getter
    private final Exception e;

    public EndMonitorCtx(boolean isTrace, String responseJson, Exception e) {
        this.isTrace = isTrace;
        this.responseJson = responseJson;
        this.e = e;
    }

    public boolean isTrace(){
        return isTrace;
    }
}
