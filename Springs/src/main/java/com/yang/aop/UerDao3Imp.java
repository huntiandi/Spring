package com.yang.aop;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/8 15:51
 */
public class UerDao3Imp implements UserDao3{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }

    @Override
    public void save() {
        System.out.println("save.......");
    }
}
