package com.yang.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 14:39
 */
public class WebUtils {
    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("appContext");
    }
}
