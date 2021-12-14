package com.yang.ioc_xml.bean;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:  部门类
 * @data: 2021/12/7 12:55
 */
public class Dept {
    private String name;

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
