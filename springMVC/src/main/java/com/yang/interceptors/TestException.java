package com.yang.interceptors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ProjectName: com.yang.interceptors
 * @author: ZhangBiBo
 * @description: 基于注解的异常处理器
 * @data: 2021/12/21
 */
@ControllerAdvice
public class TestException {
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
