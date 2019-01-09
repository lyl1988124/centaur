package com.lyl.thrift.client;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by lyl
 * Date 2019/1/8 15:32
 */
@Data
public class ServerInfo {
    private String host;

    private int port;

    /**
     * unit: ms
     */
    private int timeOut;

    private Map<String,Integer> APITimeout;

    public ServerInfo() {
    }

    public ServerInfo(String host, int port, int timeOut) {
        this.host = host;
        this.port = port;
        this.timeOut = timeOut;
    }

    public ServerInfo(String host, int port, int timeOut, Map<String, Integer> APITimeout) {
        this.host = host;
        this.port = port;
        this.timeOut = timeOut;
        this.APITimeout = APITimeout;
    }

    public int getTimeOut(String methodName){
        int defaultTimeOut = this.timeOut;
        return StringUtils.isBlank(methodName)
            || this.APITimeout == null
            || this.APITimeout.isEmpty()
            || this.APITimeout.get(methodName) == null ?
            defaultTimeOut : this.APITimeout.get(methodName);
    }
}
