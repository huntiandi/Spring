package com.yang.ioc_ann.test;

import com.yang.ioc_ann.config.SpringConfig;
import com.yang.ioc_ann.service.UserServiceAnn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/7 18:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:bean.xml")
@ContextConfiguration(classes = {SpringConfig.class})
public class Test2 {

    @Autowired
    private UserServiceAnn userServiceAnn;

    @Autowired
    private DataSource druidDataSource;

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserServiceAnn bean = applicationContext.getBean(UserServiceAnn.class);
        bean.add();
    }
    @Test
    public void test2() {
        userServiceAnn.add();
    }

    @Test
    public void test3(){
        System.out.println(druidDataSource.getClass());
    }
}