package com.yang.ioc_ann.service;

import com.yang.ioc_ann.dao.UserDao2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 可以使用任意一个注解 value可以不写 默认是类名，并且首字母小写
 *            Scope注解  也是区分单例还是多例
 * @data: 2021/12/7 18:27
 */
@Service
public class UserServiceAnn {

    @Value("abbc")
    private String name;
   /* @Autowired
    @Qualifier("daoimpl")
    private UserDao2 userDao2;*/
    @Resource(name = "daoimpl")//根据类型或者名称注入
    private UserDao2 userDao2;
    public void add(){
        System.out.println("add............"+name);
        userDao2.update();
    }
}
