package com.yang.dao;

import com.github.pagehelper.PageHelper;
import com.yang.bean.User;
import com.yang.bean.UserVo;
import com.yang.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectUserById(2);
        System.out.println(user);
        User user1 = mapper.selectUserByIdOrName(2, "张大帅比");
        System.out.println(user1);
        sqlSession.close();
    }
    @Test
    public void insertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        int rows = sqlSession.insert("com.yang.dao.UserDao.insertUser", new User("张沃德", "12345", "2131@qq.com"));
        sqlSession.commit();
        System.out.println(rows);
        sqlSession.close();
    }

    @Test
    public void selectUsers() throws IOException {
        //使用分页查询
        PageHelper.startPage(2,2);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.yang.dao.UserDao.selectUsers");
        System.out.println(users);
        sqlSession.close();
    }

    //requestMap
    @Test
    public void selectUserVo() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        UserVo userVo = mapper.selectUserVo(2);
        System.out.println(userVo);
        sqlSession.close();
    }

    //模糊查询
    @Test
    public void selectUserLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<UserVo> userList = mapper.selectUserLike("%张%");
        userList.forEach(user -> System.out.println(user));
    }
}