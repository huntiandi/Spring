package com.yang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: com.yang.utils
 * @author: ZhangBiBo
 * @description: SQLSession工具类
 * @data: 2021/12/23
 */
public class SqlSessionUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            //创建SQLSession工厂类
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //自动提交事务
    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        if (sqlSessionFactory!=null)
        return sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
