package com.yang.ioc_xml.dao;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/6 22:02
 */
public class UserDaoImpl implements UserDao{
    @Override
    public  void add() {
        System.out.println("Dao add...........");
    }

    public static void sss(){
        System.out.println("sss");
    }
}
