package com.yang.aop.cglib;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 16:09
 */
public class Advice {
    public void Before(){
        System.out.println("前置方法");
    }

    public void After(){
        System.out.println("后置方法");
    }
}
