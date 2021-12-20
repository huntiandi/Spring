package com.yang.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ProjectName: com.yang.hello.controller
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/17
 */
@Controller
public class ScopeController {
    //使用servlet共享域对象数据
    @RequestMapping("/scopeServlet")
    public String scopeTest(HttpServletRequest request){
        request.setAttribute("test","servlet共享域对象");
        return "scope";
    }

    //使用ModelAndView共享
    @RequestMapping("/scopeModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，向请求与request共享数据
        mav.addObject("test","modelAndView共享域对象");
        //设置视图名称
        mav.setViewName("scope");
        return mav;
    }

    //使用Model共享
    @RequestMapping("/scopeModel")
    public String testModel(Model model){
        model.addAttribute("test","model共享域对象");
        System.out.println(model.getClass().getName());
        return "scope";
    }

    //使用map共享
    @RequestMapping("scopeMap")
    public String testMap(Map<String,Object> map){
        map.put("test","map共享域对象");
        System.out.println(map.getClass().getName());
        return "scope";
    }

    //使用modelMap共享
    @RequestMapping("scopeModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.put("test1","modelMap共享域对象");
        modelMap.addAttribute("test","modelMap共享");
        System.out.println(modelMap.getClass().getName());
        return "scope";
    }

    //向session中共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSession","session共享");
        return "scope";
    }

    //向application中共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testApplication","Application共享");
        return "scope";
    }
}
