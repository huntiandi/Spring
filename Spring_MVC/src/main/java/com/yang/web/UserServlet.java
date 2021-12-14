package com.yang.web;

import com.yang.service.UserService;
import com.yang.utils.WebUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/9 13:48
 */
@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用工具 获取应用上下文，以避免写死getAttribute,手写的
//        ApplicationContext appContext = WebUtils.getApplicationContext(request.getServletContext());
        ApplicationContext appContext  = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        UserService userService = appContext.getBean("userServiceImpl",UserService.class);
        userService.save();
    }
}
