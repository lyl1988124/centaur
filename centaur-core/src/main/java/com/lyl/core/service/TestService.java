package com.lyl.core.service;

import com.lyl.core.dao.domain.Test;
import com.lyl.core.dao.domain.TestExample;
import com.lyl.core.dao.mapper.TestMapper;
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
