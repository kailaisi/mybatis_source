package com.kailaisi.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryUtil {
    public static SqlSessionFactory getSqlSessionFactory(){
        String path = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        try {
            Reader reader = Resources.getResourceAsReader(path);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            System.out.println("获取配置文件失败");
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}