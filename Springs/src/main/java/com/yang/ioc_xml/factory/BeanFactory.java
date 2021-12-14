package com.yang.ioc_xml.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 手写一个ioc容器
 * @data: 2021/12/8 13:19
 */
public class BeanFactory {
    //用于存放bean，相当于容器
    private static HashMap<String,Object> map = new HashMap<>();
    //可以用于读取properties的工具类，只可以读不能写，
    private static ResourceBundle bundle = ResourceBundle.getBundle("com.yang.bean");
    //将创建好的对象存入map容器中，做到单例
    static {
        try {
        //遍历配置文件中的key
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            //根据key拿出对应的路径
            String path = bundle.getString(key);
            //根据path来创建对象
                Object value = Class.forName(path).newInstance();
                map.put(key,value);
            }
        }catch (Exception e) {
            throw new ExceptionInInitializerError("创建容器失败"+e.getMessage());
        }
    }

    //将创建好的对象返回
    public static Object getBean(String beanName){
        return map.get(beanName);
    }
}
