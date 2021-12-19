package com.yang.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: com.yang.hello.controller
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/15
 */
@Controller
@RequestMapping("hello")
public class RequestMappingController {
    @RequestMapping(value = {"/success","/test"},method = {RequestMethod.POST,RequestMethod.GET},params = {"username=admin"})
    public String success(){
        return "success";
    }

    //占位符
    @RequestMapping("/testRest/{id}")
    public String testRest(@PathVariable()Integer id){
        System.out.println(id);
        return "success";
    }
}
