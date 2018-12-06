package com.lyl.service;

import com.lyl.dao.domain.Test;
import com.lyl.dao.domain.TestExample;
import com.lyl.dao.mapper.TestMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by lyl
 * Date 2018/12/6
 */
public class TestService implements TestMapper{


    @Override
    public long countByExample(TestExample example) {
        long result = this.countByExample(example);
        return result;
    }

    @Override
    public int deleteByExample(TestExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Test record) {
        return 0;
    }

    @Override
    public int insertSelective(Test record) {
        return 0;
    }

    @Override
    public List<Test> selectByExampleWithRowbounds(TestExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Test> selectByExample(TestExample example) {
        return null;
    }

    @Override
    public Test selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Test record, TestExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Test record, TestExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Test record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Test record) {
        return 0;
    }
}
