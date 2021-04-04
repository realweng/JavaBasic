package com.javasm.util;

import com.javasm.constant.Constants;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/3/9-15:15
 * @Since:jdk1.8
 * @Description:JDBC工具类
 */
public class JDBCUtils {
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(Constants.DRIVER);
            connection = DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 修改（新增、删除、修改）
     * @param sql
     * @param params
     * @return
     */
    public static int update(String sql,Object...params){
        int i = 0;
        Connection connection = getConnection();
        try {
            i = new QueryRunner().update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return i;
    }

    /**
     * 修改
     * @param connection 连接
     * @param sql
     * @param params
     * @return
     */
    public static int update(Connection connection,String sql,Object...params){
        int i = 0;
        try {
            i = new QueryRunner().update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 新增
     * @param sql
     * @param params
     * @return 返回自增的id
     */
    public static int insert(String sql,Object...params){
        int id = 0;
        Connection connection = getConnection();
        try {
            id = new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return id;
    }

    /**
     * 新增
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public static int insert(Connection connection,String sql,Object...params){
        int id = 0;
        try {
            id = new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 查询
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public static <T> List<T> query(String sql,Class<T> clazz,Object...params){
        List<T> list = new ArrayList<>(10);
        Connection connection = getConnection();
        try {
            list = new QueryRunner().query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return list;
    }

    /**
     * 根据编号查询
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public static <T> T get(String sql,Class<T> clazz,Object...params){
        T t = null;
        Connection connection = getConnection();
        try {
            t =  new QueryRunner().query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return t;
    }

    /**
     * 统计总条数
     * @param sql
     * @param <T>
     * @return
     */
    public static <T> Integer count(String sql){
        Integer count = 0;
        Connection connection = getConnection();
        try {
            count =  new QueryRunner().query(connection, sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return count;
    }
}
