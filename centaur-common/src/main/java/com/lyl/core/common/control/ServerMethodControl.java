package com.lyl.core.common.control;

import com.lyl.core.common.context.EndMonitorCtx;
import com.lyl.core.common.context.StartMonitorCtx;
import com.lyl.core.common.enums.MonitorResult;

/**
 * Created by lyl
 * Date 2018/12/27 17:49
 */
public interface ServerMethodControl extends MethodControl {
    void acceptClientControlInfo(Object context);

    void startMonitor(StartMonitorCtx ctx, String hostname);

    void endMonitor(MonitorResult monitorResult, EndMonitorCtx ctx);
}
