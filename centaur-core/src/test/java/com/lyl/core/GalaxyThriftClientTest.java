package com.lyl.core;

import com.google.gson.Gson;
import com.lyl.thrift.app.galaxy.GalaxyThrift;
import com.lyl.thrift.app.galaxy.QueryGalaxyReq;
import com.lyl.thrift.client.ServerInfo;
import com.lyl.thrift.client.ThriftClientFactory;
import com.lyl.thrift.client.ThriftServerConfig;
import com.lyl.thrift.common.Header;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.common.SignInfo;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyl
 * Date 2019/1/9 14:45
 */
public class GalaxyThriftClientTest {

    public static void main(String[] args) {
        SignInfo signInfo = new SignInfo();

        Header header = new Header();
        header.setCaller("lyl");
        signInfo.setSignMethod("RSA");



        List<ThriftServerConfig> serverConfigs = new ArrayList<>();
        ThriftServerConfig serverCfg = new ThriftServerConfig();
        serverCfg.setHost("127.0.0.1");
        serverCfg.setPort(9999);
        serverCfg.setTimeOut(30000);
        serverConfigs.add(serverCfg);
        ServerInfo[] infos = new ServerInfo[1];
        for (int i = 0; i < serverConfigs.size(); i++) {
            ThriftServerConfig serverConfig = serverConfigs.get(i);
            infos[i] = new ServerInfo(
                    serverConfig.getHost(),
                    serverConfig.getPort(),
                    serverConfig.getTimeOut());
        }
        GalaxyThrift.Iface client = ThriftClientFactory.getThriftClient(GalaxyThrift.Client.class, infos);

        System.out.println("client start success");

        QueryGalaxyReq queryGalaxyReq = new QueryGalaxyReq();
        queryGalaxyReq.setUid("2");
        Gson gson = new Gson();

        String req = gson.toJson(queryGalaxyReq);

        signInfo.setSignInfo(req);
        try {
            ReturnMsg returnMsg = client.queryGalaxy(header,signInfo,req);
            System.out.println(req);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
