package com.yang.hello.bean;

/**
 * @ProjectName: com.yang.hello.bean
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/16
 */
public class User {
    private String name;
    private String sex;
    private String hobby;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }

    public User(String name, String sex, String hobby, String address) {
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
