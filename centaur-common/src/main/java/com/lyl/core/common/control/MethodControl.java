package com.lyl.core.common.control;

import com.lyl.core.common.context.CommonMonitorCtx;
import com.lyl.core.common.enums.ControlResult;

/**
 * Created by lyl
 * Date 2018/12/27 17:19
 */
public interface MethodControl {

    ControlResult control(CommonMonitorCtx ctx);

    void releaseControl();

    boolean isTraceMethod(CommonMonitorCtx ctx);
}
