package com.yang.JDBCTemplate.dao.impl;

import com.yang.JDBCTemplate.bean.User;
import com.yang.JDBCTemplate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 21:47
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void AddUser(User user) {

          String sql = "insert into user values(?,?,?,?)";
        int i = jdbcTemplate.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
        System.out.println(i);

    }
    @Override
    public int findOne(){
        String sql = "select count(*) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
}
