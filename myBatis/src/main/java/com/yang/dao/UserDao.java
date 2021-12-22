package com.yang.dao;

import com.yang.bean.User;

/**
 * @ProjectName: com.yang.dao
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/22
 */
public interface UserDao {
    User selectUserById(Integer id);
}
