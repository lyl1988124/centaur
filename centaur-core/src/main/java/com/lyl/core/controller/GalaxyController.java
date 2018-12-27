package com.lyl.core.controller;

import com.lyl.core.dao.domain.Galaxy;
import com.lyl.core.service.GalaxyService;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.galaxy.CreateGalaxyReq;
import com.lyl.thrift.galaxy.QueryGalaxyReq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @ResponseBody
    public ReturnMsg createGalaxy(CreateGalaxyReq req){
        ReturnMsg returnMsg = galaxyService.createGalaxy(req);
        return  returnMsg;
    }

    @RequestMapping("/query")
    public String helloGalaxy(QueryGalaxyReq req,Model model){

        ReturnMsg returnMsg = galaxyService.queryGalaxy(req);

        model.addAttribute("name","bb");
        return "/html/Hello";
    }
}
