package com.lyl;

import com.lyl.dao.domain.TestExample;
import com.lyl.dao.mapper.TestMapper;
import com.lyl.service.TestService;

/**
 * Created by lyl
 * Date 2018/11/28
 */

public class App {
    public static void main(String[] args) {
        TestService testService = new TestService();
        TestExample testExample = new TestExample();
        TestExample.Criteria criteria = testExample.createCriteria();
        criteria.andIdEqualTo(1);
        System.out.println(testService.countByExample(testExample));
    }
}
