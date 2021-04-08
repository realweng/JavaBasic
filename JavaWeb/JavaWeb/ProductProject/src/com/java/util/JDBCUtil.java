package com.java.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import com.java.constants.UserConstants;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-20:23
 * @Since:jdk1.8
 * @Description:JDBC工具类
 */
public class JDBCUtil {
    // 连接池数据源
    private static DruidDataSource druidDataSource;

    // 静态代码块 类加载的时候执行一次
    static {
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("com/java/resource/druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     *
     * @return
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            //加载驱动
//            Class.forName(UserConstants.DRIVER);
//            //获取连接
//            con = DriverManager.getConnection(UserConstants.URL, UserConstants.SQL_USER, UserConstants.SQL_PASSWORD);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return con;
    }

    /**
     * 数据库查询操作
     *
     * @param sql    sql语句
     * @param params sql参数
     * @return
     */
    public static int update(String sql, Object... params) {
        int i = 0;
        QueryRunner queryRunner = new QueryRunner();
        Connection con = getConnection();
        if (con != null) {
            try {
                //执行更新数据操作
                i = queryRunner.update(con, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //关闭连接
                DbUtils.closeQuietly(con);
            }
        }
        return i;
    }

    /**
     * 重载update()方法，传入连接的更新数据方法
     *
     * @param con    将连接当形参传进来，确保事务中的 update 操作都是在一个连接里面
     * @param sql
     * @param params
     * @return
     */
    public static int update(Connection con, String sql, Object... params) {
        int i = 0;
        QueryRunner queryRunner = new QueryRunner();
        if (con != null) {
            try {
                //执行更新数据操作
                i = queryRunner.update(con, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//在这里不能关闭连接，连接断开就不能保证事务中的操作在一个连接中
        return i;
    }

    /**
     * 数据库查询操作
     *
     * @param sql    SQL语句
     * @param clazz
     * @param params SQL参数
     * @param <T>    类型
     * @return 返回查询结果的list
     */
    public static <T> List<T> query(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>(10);
        QueryRunner queryRunner = new QueryRunner();
        Connection con = getConnection();
        if (con != null) {
            try {
                list = queryRunner.query(con, sql, new BeanListHandler<>(clazz), params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(con);
            }
        }
        return list;
    }

    /**
     * 通过id查询1个结果
     *
     * @param sql   SQL语句
     * @param clazz 反射
     * @param id    要查询的编号
     * @param <T>   泛型
     * @return
     */
    public static <T> T getResultById(String sql, Class<T> clazz, Integer id) {
        T t = null;
        QueryRunner queryRunner = new QueryRunner();
        Connection con = getConnection();
        if (con != null) {
            try {
                t = queryRunner.query(con, sql, new BeanHandler<>(clazz), id);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(con);
            }
        }
        return t;
    }

    /**
     * 统计总条数
     *
     * @param sql
     * @param <T>
     * @return
     */
    public static <T> Integer count(String sql) {
        Integer count = 0;
        Connection connection = getConnection();
        try {
            count = new QueryRunner().query(connection, sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return count;
    }
}