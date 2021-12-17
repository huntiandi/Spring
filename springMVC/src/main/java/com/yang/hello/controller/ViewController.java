package com.yang.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: com.yang.hello.controller
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/17
 */
@Controller
public class ViewController {

    //测试Thymeleaf视图转化器
    @RequestMapping("/testViewThymeleaf")
    public String testView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        //会去掉forward来进行转发
        return "forward:/testViewThymeleaf";
    }
}
