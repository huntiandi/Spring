package com.yang.ioc_ann.dao;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/7 22:28
 */
@Repository(value = "daoimpl")
public class UserDaoImpl2 implements UserDao2{
    @Override
    public void update() {
        System.out.println("daoUpdate.........");
    }
}
