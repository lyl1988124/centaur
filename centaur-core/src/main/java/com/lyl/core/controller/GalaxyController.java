package com.lyl.core.controller;

import com.google.gson.Gson;
import com.lyl.core.service.GalaxyService;
import com.lyl.core.thrift.common.GalaxyThriftConfig;
import com.lyl.thrift.app.galaxy.GalaxyThrift;
import com.lyl.thrift.client.ServerInfo;
import com.lyl.thrift.client.ThriftClientFactory;
import com.lyl.thrift.client.ThriftServerConfig;
import com.lyl.thrift.common.Header;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.app.galaxy.CreateGalaxyReq;
import com.lyl.thrift.app.galaxy.QueryGalaxyReq;
import com.lyl.thrift.common.SignInfo;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by lyl
 * Date 2018/12/25 21:05
 */
@Controller
@RequestMapping("/galaxy")
public class GalaxyController {

    @Resource
    GalaxyService galaxyService;

    @Resource
    GalaxyThriftConfig galaxyThriftConfig;

    private GalaxyThrift.Iface galaxyThriftClient;

    @PostConstruct
    private void initThriftClient(){
        ServerInfo[] infos = new ServerInfo[galaxyThriftConfig.getServers().size()];
        for (int i = 0; i < galaxyThriftConfig.getServers().size(); i++) {
            ThriftServerConfig serverCfg = galaxyThriftConfig.getServers().get(i);
            infos[i] = new ServerInfo(
                    serverCfg.getHost(),
                    serverCfg.getPort(),
                    serverCfg.getTimeOut());
        }
        this.galaxyThriftClient = ThriftClientFactory.getThriftClient(GalaxyThrift.Client.class, infos);
    }

    @RequestMapping("/create")
    @ResponseBody
    public ReturnMsg createGalaxy(CreateGalaxyReq req){
        ReturnMsg returnMsg = galaxyService.createGalaxy(req);
        return  returnMsg;
    }

    @RequestMapping("/query")
    @ResponseBody
    public ReturnMsg queryGalaxy(QueryGalaxyReq req,Model model){

        ReturnMsg returnMsg = galaxyService.queryGalaxy(req);

        return returnMsg;
    }

    @RequestMapping("/select")
    public String selectGalaxy(QueryGalaxyReq req,Model model){

        ReturnMsg returnMsg = galaxyService.queryGalaxy(req);

        model.addAttribute("name","bb");
        return "/html/Hello";
    }

    @RequestMapping("/thrift/query")
    @ResponseBody
    public ReturnMsg selectGalaxyThrift(QueryGalaxyReq req,Model model){

        SignInfo signInfo = new SignInfo();

        Header header = new Header();
        header.setCaller("lyl");
        signInfo.setSignMethod("RSA");

        System.out.println("client start success");

        Gson gson = new Gson();
        String reqParam = gson.toJson(req);

        signInfo.setSignInfo(reqParam);
        ReturnMsg returnMsg = null;
        try {
            returnMsg = galaxyThriftClient.queryGalaxy(header,signInfo,reqParam);
            System.out.println(req);
        } catch (TException e) {
            e.printStackTrace();
        }

        return returnMsg;
    }


}
