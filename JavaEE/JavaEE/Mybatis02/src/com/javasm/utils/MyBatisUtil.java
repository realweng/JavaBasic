package com.javasm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-16:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String config = "mybatis-config.xml";
        try {
            //获取配置
            Reader reader = Resources.getResourceAsReader(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 获取SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}