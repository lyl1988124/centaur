package com.lyl.core.common.code;

/**
 * Created by lyl
 * Date 2018/12/25 20:20
 */
public class BaseReturnCode {

    /**操作 start*/
    public static final ReturnCode SUCCESS=new ReturnCode(10000,"成功");

    public static final ReturnCode REPEAT=new ReturnCode(10001,"重复操作");

    public static final ReturnCode REQUEST_ACCEPT=new ReturnCode(10010,"已受理");

    /**操作 end*/


    /**服务器 start*/
    public static final ReturnCode SERVER_ERROR =new ReturnCode(20000,"服务器异常");

    public static final ReturnCode SERVER_BUSY=new ReturnCode(20001,"服务器繁忙");

    public static final ReturnCode SERVER_LIMITING=new ReturnCode(20002,"服务器限流");

    /**服务器 end*/

    /**数据start*/
    public static final ReturnCode DATA_EXIST=new ReturnCode(30001,"数据已存在");
    public static final ReturnCode DATA_NOT_EXIST=new ReturnCode(30002,"数据不存在");
    /**数据end*/

}
