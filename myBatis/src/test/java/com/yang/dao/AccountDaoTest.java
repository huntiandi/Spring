package com.yang.dao;

import com.yang.bean.Account;
import com.yang.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: com.yang.dao
 * @author: ZhangBiBo
 * @description: 动态sql测试类
 * @data: 2021/12/25
 */
public class AccountDaoTest {

    @Test
    public void selectIf() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setUsername("张洋");
        List<Account> accounts = mapper.selectIf(account);
        accounts.forEach(account1 -> System.out.println(account1));
        sqlSession.close();
    }

    @Test
    public void selectWhere() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setUsername("");
        List<Account> accounts = mapper.selectWhere(account);
        accounts.forEach(account1 -> System.out.println(account1));
        sqlSession.close();
    }


    @Test
    public void selectForEach() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Integer> accounts = new ArrayList<>();
        accounts.add(1);
        accounts.add(2);
        List<Account> accounts1 = mapper.selectForEach(accounts);
        accounts1.forEach(account -> System.out.println(account));
    }

    @Test
    public void selectForEach2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = new ArrayList<>();
        account1.setId(1);
        account2.setId(2);
        accounts.add(account1);
        accounts.add(account2);
        List<Account> accounts1 = mapper.selectForEach2(accounts);
        accounts1.forEach(account -> System.out.println(account));
    }
}