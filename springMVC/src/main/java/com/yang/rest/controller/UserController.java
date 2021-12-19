package com.yang.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 使用restFul风格模拟用户资源的增删改查
 * @data: 2021/12/19 21:27
 */
@Controller
public class UserController {

    //查询所有用户信息 /user GET请求
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询到所有用户信息");
        return "success";
    }

    //查询指定用户信息 /user/1 GET请求
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id")Integer id){
        System.out.println("查询"+id+"用户信息");
        return "success";
    }

    //新增用户
    @PostMapping("/user")
    public String saveUser(@RequestParam("username")String username,
                           @RequestParam("password")String password){
        System.out.println("新增用户用户名:"+username+"密码:"+password);
        return "success";
    }

    //修改用户
    @PutMapping("/user")
    public String updateUser(String username,String password){
        System.out.println("修改用户用户名:"+username+"密码:"+password);
        return "success";
    }
}
