package com.lyl.core.common.enums;

/**
 * Created by lyl
 * Date 2018/12/27 18:20
 */
public enum MonitorResult {
    RUN_NOMAL,RUN_CONTROL_FAIL, RUN_LOCAL_BREAK, RUN_REMOTE_BREAK, RUN_EXP,RUN_SIGN_FAIL;

    public static MonitorResult fromControlResult(ControlResult controlResult,boolean isLocal){
        switch (controlResult){
            case BREAK:
                return isLocal ? RUN_LOCAL_BREAK : RUN_REMOTE_BREAK;
            case LIMIT:
                return RUN_CONTROL_FAIL;
            default:
               throw new RuntimeException("not support!");
        }
    }
}
