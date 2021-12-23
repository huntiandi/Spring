package com.yang.dao;

import com.yang.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: com.yang.dao
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/22
 */
public interface UserDao {
    User selectUserById(Integer id);

    User selectUserByIdOrName(@Param("id") Integer id,
                              @Param("username") String username);

    List<User> selectUsers();

    int insertUser(User user);
}
