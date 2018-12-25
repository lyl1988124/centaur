package com.lyl.core;

import com.lyl.core.service.GalaxyService;
import com.lyl.thrift.galaxy.CreateGalaxyReq;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by lyl
 * Date 2018/12/25 20:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lyl.core.dao.mapper")
public class GalaxyTest {
    @Resource
    GalaxyService galaxyService;

    @org.junit.Test
    public void testSelectTest(){
        CreateGalaxyReq req = new CreateGalaxyReq();
        req.setName("lyl");
        req.setAge(18);
        galaxyService.createGalaxy(req);
    }
}
