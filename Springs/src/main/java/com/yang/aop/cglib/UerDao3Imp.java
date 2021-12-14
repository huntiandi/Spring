package com.yang.aop.cglib;

import com.yang.aop.UserDao3;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/8 15:51
 */
public class UerDao3Imp {
    public int add(int a, int b) {
        return a+b;
    }

    public String update(String id) {
        return id;
    }

    public void save() {
        System.out.println("save.......");
    }
}
