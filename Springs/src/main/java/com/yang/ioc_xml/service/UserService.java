package com.yang.ioc_xml.service;

import com.yang.ioc_xml.dao.UserDao;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/6 22:02
 */
public class UserService {
    //手写bean工厂实现ioc解耦
//    private UserDao userDao = (UserDaoImpl) BeanFactory.getBean("dao");

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add..........");
        userDao.add();
    }
}
