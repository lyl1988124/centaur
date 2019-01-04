package com.lyl.core;

import com.google.gson.Gson;
import com.lyl.thrift.common.Header;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.common.SignInfo;
import com.lyl.thrift.galaxy.GalaxyThrift;
import com.lyl.thrift.galaxy.QueryGalaxyReq;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URLEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by lyl
 * Date 2019/1/3 20:20
 */

public class GalaxyThriftTest {

    public static void main(String[] args) {

        SignInfo signInfo = new SignInfo();
        Header header = new Header();
        header.setCaller("lyl");
        signInfo.setSignMethod("RSA");


        System.out.println("客户端启动....");
        TTransport transport = null;
        transport = new TSocket("127.0.0.1", 9999, 30000);
        // 协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(transport);
        GalaxyThrift.Client client = new GalaxyThrift.Client(protocol);
        System.out.println("client start success");
        try {
            transport.open();
        } catch (
                TTransportException e) {
            e.printStackTrace();
        }
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
