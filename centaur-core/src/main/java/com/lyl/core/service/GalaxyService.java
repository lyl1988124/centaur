package com.lyl.core.service;

import com.lyl.core.dao.domain.Galaxy;
import com.lyl.core.dao.mapper.GalaxyMapper;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.galaxy.CreateGalaxyReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lyl
 * Date 2018/12/25 20:10
 */
@Service
public class GalaxyService {

    @Resource
    GalaxyMapper mapper;

    public ReturnMsg createGalaxy(CreateGalaxyReq req){
        ReturnMsg returnMsg = new ReturnMsg();

        Galaxy galaxy = new Galaxy();
        galaxy.setUid(req.getUid());
        galaxy.setAge(req.getAge());
        galaxy.setName(req.getName());
        galaxy.setExtInfo(req.getExtInfo());
        galaxy.setCaller(req.getCaller());

        int result = mapper.insertSelective(galaxy);

        returnMsg.setReturnResponse(String.valueOf(result));
        return  returnMsg;
    }
}
