package com.yang.hello.controller;

import com.yang.hello.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 通过形参获取参数类
 * @data: 2021/12/15 23:14
 */
@Controller
public class ParamController {
    //通过控制器形参获取参数
    @RequestMapping("/param")
    public String testParam(String username, String password, String hobby){
        System.out.println(username+password+"爱好是："+hobby);
        return "param";
    }

    //通过注解获取参数
    @RequestMapping("/testParam")
    public String testParam2(@RequestParam(value = "user_name",defaultValue = "") String username,
                             @RequestParam("pas")Integer pas,
                             @RequestHeader("Host")String host){
        System.out.println(username+pas);
        System.out.println(host);
        return "success";
    }
    @RequestMapping("/bean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
