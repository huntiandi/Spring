package com.yang.JDBCTemplate.service.Impl;

import com.yang.JDBCTemplate.bean.User;
import com.yang.JDBCTemplate.service.UserService;
import com.yang.JDBCTemplate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 21:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void AddUser(User user) {
            userDao.AddUser(user);
    }
}
