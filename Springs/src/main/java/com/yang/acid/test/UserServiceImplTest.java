package com.yang.acid.test;

import com.yang.acid.bean.account;
import com.yang.acid.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/12 22:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {
    private static final Logger log = LogManager.getLogger();
    @Autowired
    private UserService serviceAcid;
    @Test
    public void transfer() {
        log.info("转账业务开始");
        serviceAcid.transfer();
    }

    @Test
    public void mm(){
        log.info("函数时表达式注册对象");
        GenericApplicationContext context = new GenericApplicationContext();
        //对象注册
        context.refresh();
        context.registerBean("account",account.class,() -> new account());
        account account = (account) context.getBean("account");
        System.out.println(account);
    }
}