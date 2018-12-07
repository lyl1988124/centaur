package com.lyl.service;

import com.lyl.dao.domain.Test;
import com.lyl.dao.domain.TestExample;
import com.lyl.dao.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyl
 * Date 2018/12/6
 */
@Service
public class TestService {

    @Resource
    TestMapper mapper;

    public List<Test> selectTestList(TestExample example){
        return mapper.selectByExample(example);
    }
}
