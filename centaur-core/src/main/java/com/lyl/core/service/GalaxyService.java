package com.lyl.core.service;

import com.lyl.core.dao.domain.Galaxy;
import com.lyl.core.dao.domain.GalaxyExample;
import com.lyl.core.dao.mapper.GalaxyMapper;
import com.lyl.thrift.common.ReturnMsg;
import com.lyl.thrift.galaxy.CreateGalaxyReq;
import com.lyl.thrift.galaxy.QueryGalaxyReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        if(null!=req.getUid())
            galaxy.setUid(req.getUid());
        galaxy.setAge(req.getAge());
        if(null!=req.getName())
            galaxy.setName(req.getName());
        if(null!=req.getExtInfo())
            galaxy.setExtInfo(req.getExtInfo());
        if(null!=req.getCaller())
            galaxy.setCaller(req.getCaller());

        int result = mapper.insertSelective(galaxy);

        returnMsg.setReturnResponse(String.valueOf(result));
        return  returnMsg;
    }

    public ReturnMsg queryGalaxy(QueryGalaxyReq req){
        ReturnMsg returnMsg = new ReturnMsg();

        GalaxyExample example = new GalaxyExample();
        GalaxyExample.Criteria criteria = example.createCriteria();

        if(null!=req.getUid()) {
            criteria.andUidEqualTo(req.getUid());
        } else {
            return returnMsg;
        }
        List<Galaxy> galaxies = mapper.selectByExample(example);
        if (galaxies.size()>0){
            Galaxy galaxy = galaxies.get(0);
            returnMsg.setReturnResponse(String.valueOf(galaxy));
        }
        return  returnMsg;
    }
}
