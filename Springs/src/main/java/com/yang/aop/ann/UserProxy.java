package com.yang.aop.ann;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 增强类
 * @data: 2021/12/9 16:46
 */
@Component
@Aspect//生成代理对象
@Order(1)
public class UserProxy {

    //相同切入点的抽取
    @Pointcut(value = "execution(* com.yang.aop.ann.User.add(..))")
    public void pointcut(){
    }
    //前置通知
    @Before(value = "pointcut()")
    public void Before(){
        System.out.println("前置通知。。。。。");
    }

    //有没有异常都执行
    @After("pointcut()")
    public void After(){
        System.out.println("最终通知。。。。。。");
    }

    @Around("pointcut()")
    public void Surround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前。。。。。。。");
        //执行被通知方法
        proceedingJoinPoint.proceed();
        //有异常不执行
        System.out.println("环绕通知后。。。。。。。");
    }
    //有异常就不执行了
    @AfterReturning("pointcut()")
    public void AfterReturning(){
        System.out.println("后置通知。。。。。。。");
    }
    @AfterThrowing("pointcut()")
    public void AfterThrowing(){
        System.out.println("异常通知。。。。。。。");
    }
}
