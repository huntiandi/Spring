package com.yang.JDBCTemplate.dao;

import com.yang.JDBCTemplate.bean.User;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 21:47
 */
public interface UserDao {
    public void AddUser(User user);
    public int findOne();
}
