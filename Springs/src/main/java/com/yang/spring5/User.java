package com.yang.spring5;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/11/30 11:04
 */
public class User {
    private String name;
    private String sex;
    private String hobby;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void add(){
        System.out.println("add被调用");
        System.out.println("名字："+name+" 性别："+sex+" 爱好是："+hobby+" 家庭地址："+address);
    }

    public User(String name, String sex, String hobby, String address) {
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
        this.address = address;
    }
}
