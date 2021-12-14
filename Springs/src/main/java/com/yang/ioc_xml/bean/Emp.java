package com.yang.ioc_xml.bean;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 员工类
 * @data: 2021/12/7 12:55
 */
public class Emp {
    private String userName;
    private String gender;
    private Dept dept;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
