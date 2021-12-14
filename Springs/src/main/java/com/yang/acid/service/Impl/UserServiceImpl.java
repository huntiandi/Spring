package com.yang.acid.service.Impl;

import com.yang.acid.dao.UserDao;
import com.yang.acid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/11 17:56
 */
@Service("serviceAcid")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDaoAcid;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,readOnly = false,timeout = -1,rollbackFor = NullPointerException.class)
    @Override
    public void transfer() {
        UserDaoAcid.reduceMoney();

//        int a = 10/0;
        UserDaoAcid.addMoney();

        System.out.println("转账完成");
    }
}
