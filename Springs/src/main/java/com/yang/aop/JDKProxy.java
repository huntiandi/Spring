package com.yang.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 使用jdk实现动态代理
 * @data: 2021/12/8 15:52
 */
public class JDKProxy {
    public static void main (String[] args){
        //目标对象
        final UerDao3Imp uerDao3Imp = new UerDao3Imp();
        //增强对象
        final Advice advice =new Advice();
    //创建实现类代理对象
        /*
        * 三个参数：1.目标对象类加载器；2目标对象相同的接口字节码对象数组，支持多个接口；3创建代理对象，写增强的方法
        * */
       UserDao3 proxy = (UserDao3) Proxy.newProxyInstance(uerDao3Imp.getClass().getClassLoader(), uerDao3Imp.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象的引用
             * @param method 当前执行的目标方法
             * @param args 当前执行方法所需要的参数
             * @return 当前执行方法返回hi
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.Before();
                Object invoke = method.invoke(uerDao3Imp, args);
                advice.After();
                return invoke;
            }
        });
        System.out.println(proxy.add(1,2));
    }
}