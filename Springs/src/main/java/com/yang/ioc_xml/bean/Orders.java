package com.yang.ioc_xml.bean;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: bean的生命周期
 * * @data: 2021/12/7 15:48
 */
public class Orders {
    private String nam;

    public Orders() {
        System.out.println("1.无参调用。。。。");
    }

    public void setNam(String nam) {
        System.out.println("2.set调用设置属性");
        this.nam = nam;
    }

    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("3.执行初始化方法");
    }

    //销毁方法
    public void destroyMethod(){
        System.out.println("5.bean销毁");
    }
}
