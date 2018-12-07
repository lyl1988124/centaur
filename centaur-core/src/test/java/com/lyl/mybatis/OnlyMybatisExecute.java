package com.lyl.mybatis;

import com.lyl.dao.domain.Test;
import com.lyl.dao.domain.TestExample;
import com.lyl.dao.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lyl
 * Date 2018/12/7
 * 只使用mybatis调用数据库
 */
public class OnlyMybatisExecute {
    public static void main(String[] args) {
        String resource = "only_mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        TestExample testExample = new TestExample();
        TestExample.Criteria criteria = testExample.createCriteria();
        criteria.andIdEqualTo(2);
        List<Test> list = testMapper.selectByExample(testExample);
        System.out.println(list);

        sqlSession.close();
    }
}
