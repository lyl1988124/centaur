package com.lyl.mybatis;

import com.lyl.dao.domain.Test;
import com.lyl.dao.domain.TestExample;
import com.lyl.service.TestService;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyl
 * Date 2018/12/7
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisExecuteTest {

    @Resource
    TestService testService;

    @org.junit.Test
    public void testSelectTest(){
        TestExample testExample = new TestExample();

        List<Test> list = testService.selectTestList(testExample);
        System.out.println(list);
    }

}
