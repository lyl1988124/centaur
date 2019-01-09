package com.lyl.thrift.client;

/**
 * Created by lyl
 * Date 2019/1/8 17:41
 */
public class RpcException extends RuntimeException {

    private static final long serialVersionUID = 928880072248645460L;

    public RpcException(){
        super();
    }

    public RpcException(String message, Throwable cause,
                        boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RpcException(String message, Throwable cause){
        super(message, cause);
    }

    public RpcException(String message) {
        super(message);
    }

    public RpcException(Throwable cause) {
        super(cause);
    }
}
