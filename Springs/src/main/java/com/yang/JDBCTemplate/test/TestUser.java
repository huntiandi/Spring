package com.yang.JDBCTemplate.test;

import com.yang.JDBCTemplate.bean.User;
import com.yang.JDBCTemplate.service.UserService;
import com.yang.JDBCTemplate.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 22:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Test
    public void add(){
        User us = new User();
        us.setEmail("2121");
        us.setPassword("sadsa");
        us.setUsername("sdsadada");
        userService.AddUser(us);
    }

    @Test
    public void find(){
        int one = userDao.findOne();
        System.out.println(one);
    }

}
