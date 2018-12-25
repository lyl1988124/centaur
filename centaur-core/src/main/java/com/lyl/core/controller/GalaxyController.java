package com.lyl.core.controller;

import com.lyl.core.dao.domain.Galaxy;
import com.lyl.core.service.GalaxyService;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.galaxy.CreateGalaxyReq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/create")
    public ReturnMsg createGalaxy(CreateGalaxyReq req){
        ReturnMsg returnMsg = galaxyService.createGalaxy(req);
        return  returnMsg;
    }
}
