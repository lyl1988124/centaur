package com.lyl.core.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lyl
 * Date 2018/12/25 20:21
 */
@AllArgsConstructor
public final class ReturnCode {

    @Getter
    private Integer code;

    @Getter
    private String msg;

    public boolean isSuccess(){
        return this.code>=10000 && this.code<20000;
    }

    public ReturnCode format(Object... params){
        ReturnCode returnCode = new ReturnCode(this.code,this.msg);
        returnCode.msg=String.format(this.msg,params);
        return  returnCode;
    }
}
