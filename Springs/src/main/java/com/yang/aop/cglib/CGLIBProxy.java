package com.yang.aop.cglib;

import com.yang.aop.UserDao3;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 使用jdk实现动态代理
 * @data: 2021/12/8 15:52
 */
public class CGLIBProxy {
    public static void main (final String[] args){
        //目标对象
        final UerDao3Imp uerDao3Imp = new UerDao3Imp();
        //增强对象
        final Advice advice =new Advice();
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(UerDao3Imp.class);
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.Before();
                Object invoke = method.invoke(uerDao3Imp, args);
                advice.After();
                return invoke;
            }
        });
        //创建代理对象
        UerDao3Imp proxy = (UerDao3Imp) enhancer.create();
        proxy.save();
    }
}