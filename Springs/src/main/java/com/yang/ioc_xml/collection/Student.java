package com.yang.ioc_xml.collection;

import com.yang.ioc_xml.bean.Emp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 数组的配置
 * @data: 2021/12/7 13:13
 */
public class Student {
    private String[] courses;

    private List<String> list;

    private Map<String,String> map;

    private Set<String> set;

    private List<Emp> empList;

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void system(){
        System.out.println(Arrays.asList(courses));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(empList);
    }
}
