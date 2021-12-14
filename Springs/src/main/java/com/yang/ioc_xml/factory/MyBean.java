package com.yang.ioc_xml.factory;

import com.yang.ioc_xml.bean.Emp;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 工厂bean
 * @data: 2021/12/7 15:26
 */
public class MyBean implements FactoryBean<Emp> {
    /**
     *
     * @return 定义返回bean
     * @throws Exception
     */
    @Override
    public Emp getObject() throws Exception {
        Emp emp = new Emp();
        emp.setUserName("sssss");
        return emp;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
