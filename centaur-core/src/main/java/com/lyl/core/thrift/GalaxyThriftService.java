package com.lyl.core.thrift;

import com.google.gson.Gson;
import com.lyl.core.service.GalaxyService;
import com.lyl.thrift.common.Header;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.common.SignInfo;
import com.lyl.thrift.galaxy.GalaxyThrift;
import com.lyl.thrift.galaxy.QueryGalaxyReq;
import com.lyl.thrift.thrift.ExportableThriftService;
import com.lyl.thrift.thrift.ThriftProtocol;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lyl
 * Date 2019/1/3 18:19
 */
@Service
@ExportableThriftService(protocol = ThriftProtocol.HEADER_BINARY)
public class GalaxyThriftService implements GalaxyThrift.Iface {
    @Resource
    GalaxyService galaxyService;


    @Override
    public ReturnMsg createGalaxy(Header header, SignInfo signInfo, String requestInfo) throws TException {
        Gson gson = new Gson();
        QueryGalaxyReq req = gson.fromJson(requestInfo,QueryGalaxyReq.class);
        ReturnMsg returnMsg = galaxyService.queryGalaxy(req);

        return returnMsg;
    }

    @Override
    public ReturnMsg queryGalaxy(Header header, SignInfo signInfo, String requestInfo) throws TException {
        Gson gson = new Gson();
        QueryGalaxyReq req = gson.fromJson(requestInfo,QueryGalaxyReq.class);
        ReturnMsg returnMsg = galaxyService.queryGalaxy(req);

        return returnMsg;
    }

    @Override
    public ReturnMsg updateGalaxy(Header header, SignInfo signInfo, String requestInfo) throws TException {
        return null;
    }
}
