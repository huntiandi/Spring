package com.yang.acid.test;

import com.yang.acid.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/13 16:59
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class Jtest5 {
    private static final Logger log = LogManager.getLogger();
    @Autowired
    private UserService serviceAcid;
    @Test
    public void transfer() {
        log.info("转账业务开始");
        serviceAcid.transfer();
    }
}
