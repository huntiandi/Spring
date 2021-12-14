package com.yang.ioc_xml.test;

import com.yang.ioc_xml.bean.Emp;
import com.yang.ioc_xml.bean.Orders;
import com.yang.ioc_xml.collection.Student;
import com.yang.ioc_xml.service.UserService;
import com.yang.spring5.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: IOC的实现
 * @data: 2021/11/30 11:09
 */
class UserTest {

    @Test
    void add() {
        //加载配置对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    /**
     * 注入外部bean的测试
     */
    @Test
    void Add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    void EmD(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    void StudentTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Student student = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        System.out.println(student);
        System.out.println(student2);//student地址和student2地址相同，说明是单实例默认情况
        student.system();
    }

    /*
    * 工厂bean的测试
    * */
    @Test
    void beanTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Emp emp = context.getBean("myBean", Emp.class);
        System.out.println(emp);
    }

    @Test
    void ordersTest(){
        //ApplicationContext没有close
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("4.获取创建的bean实例对象");
        System.out.println(orders);
        //手动调用销毁方法
        context.close();
    }
   }