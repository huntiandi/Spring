package com.yang.aop.ann;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 16:45
 */
@Component
public class User {
    public void add(){
//        int i = 12/0;
        System.out.println("save......");
    }
}
