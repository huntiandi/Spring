package com.yang.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: com.yang.controller
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/14
 */
@Controller
public class HelloController {
    /*//请求映射
    @RequestMapping("/")
    public String index(){
        //返回视图请求，加上前缀后缀就是全路径了
        return "index";
    }
*/
    @RequestMapping("/index2")
    public String index2(){
        return "index2";
    }

    @RequestMapping("/testView")
    public String testView(){
        return "view";
    }
}
