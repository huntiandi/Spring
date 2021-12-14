package com.yang.ioc_ann.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description: 配置类代替xml,纯注解，在里面写方法时再加一个@Bean会把结果放入容器，其他类可以使用import注解，有配置文件时
 * 要加入一个PropertySource注解
 * @data: 2021/12/7 22:48
 */
@Configuration//表示为配置文件
@ComponentScan(basePackages = {"com.yang.ioc_ann"})//开启扫描
@Import(DruidDataSource.class)//引入其他配置文件
@EnableTransactionManagement//开启事务
public class SpringConfig {

}
