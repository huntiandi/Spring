package com.yang.dao;

import com.yang.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @ProjectName: com.yang.dao
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/22
 */
public class UserDaoTest {

    @Test
    public void selectUserById() throws IOException {
        //配置文件位置
        String resource = "mybatis.xml";
        //使用框架中的resource类
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory 类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserDao.selectUserById",2);
        System.out.println(user);
    }
}