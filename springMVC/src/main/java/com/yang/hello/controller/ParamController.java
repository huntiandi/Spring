package com.yang.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/15 23:14
 */
@Controller
public class ParamController {
    @RequestMapping("/param")
    public String testParam(String username,String password){
        System.out.println(username+password);
        return "param";
    }
}
