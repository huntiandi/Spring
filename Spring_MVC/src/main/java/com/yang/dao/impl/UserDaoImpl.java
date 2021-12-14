package com.yang.dao.impl;

import com.yang.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 13:44
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("dao.....save......");
    }
}
