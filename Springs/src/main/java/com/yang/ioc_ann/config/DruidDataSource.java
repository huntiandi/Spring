package com.yang.ioc_ann.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @ProjectName: Spring
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/12/12 22:30
 */
@PropertySource("classpath:jdbc.properties")//引入properties
public class DruidDataSource {
    @Value("${prop.driverClassName}")
    private String driver;
    @Value("${prop.url}")
    private String url;
    @Value("${prop.username}")
    private String username;
    @Value("${prop.password}")
    private String password;

    @Bean("druidDataSource")
    public DataSource getDataSource() {
        com.alibaba.druid.pool.DruidDataSource druidDataSource = new com.alibaba.druid.pool.DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
