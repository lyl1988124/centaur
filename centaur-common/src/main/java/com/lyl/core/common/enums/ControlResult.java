package com.lyl.core.common.enums;

/**
 * Created by lyl
 * Date 2018/12/27 17:20
 */
public enum  ControlResult {
    NOMAL,LIMIT,BREAK;

    public static ControlResult ofName(String name){
        for(ControlResult result : ControlResult.values()){
            if(name.equals(result.name())){
                return result;
            }
        }
        return null;
    }

    public static ControlResult getControlResult(boolean result){
        if(result){
            return NOMAL;
        }else{
            return BREAK;
        }
    }
}
