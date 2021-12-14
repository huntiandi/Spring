package com.yang.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 添加监听器，获取应用上下文
 * @data: 2021/12/9 14:25
 */
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext appContext = new ClassPathXmlApplicationContext(servletContext.getInitParameter("applicationContext"));
        //将上下文存到ServletContext域中
        servletContext.setAttribute("appContext",appContext);
        System.out.println("spring容器创建成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
