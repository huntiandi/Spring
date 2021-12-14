package com.yang.aop.ann;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 20:53
 */
@Component
@Aspect
@Order(2)
public class UserPeoxy2 {
    @Before(value = "execution(* com.yang.aop.ann.User.add(..))")
    public void before(){
        System.out.println("proxy2........");
    }
}
