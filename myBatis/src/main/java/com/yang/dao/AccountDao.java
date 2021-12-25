package com.yang.dao;

import com.yang.bean.Account;

import java.util.List;

/**
 * @ProjectName: com.yang.dao
 * @author: ZhangBiBo
 * @description: 动态sql的对应dao接口
 * @data: 2021/12/25
 */
public interface AccountDao {
    List<Account> selectIf(Account account);

    List<Account> selectWhere(Account account);

    //遍历简单类型
    List<Account> selectForEach(List<Integer> list);

    //forEach遍历对象
    List<Account> selectForEach2(List<Account> list);
}
