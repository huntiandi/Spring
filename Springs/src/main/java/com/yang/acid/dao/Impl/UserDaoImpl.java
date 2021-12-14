package com.yang.acid.dao.Impl;

import com.yang.acid.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/11 17:56
 */
@Repository("UserDaoAcid")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //多钱方法
    @Override
    public void addMoney() {
        String sql = "update t_account set money = money+? where username = ?";
        int i = jdbcTemplate.update(sql, 100, "丁鉴夷");
        System.out.println(i+"成功多钱");
    }

    //少钱方法
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money-? where username = ?";
        int i = jdbcTemplate.update(sql, 100, "张洋");
        System.out.println(i+"成功少钱");
    }

}
