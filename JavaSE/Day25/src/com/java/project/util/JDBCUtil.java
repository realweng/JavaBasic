package com.java.project.util;

import com.java.project.constants.ClockInConstants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-10:31
 * @Since:jdk1.8
 * @Description:JDBC工具类
 */
public class JDBCUtil {
    private static Connection con;
    private static PreparedStatement pstm;
    private static ResultSet rs;

    /**
     * 数据库获取连接
     *
     * @return 返回连接对象
     */
    public static Connection getCon() {
        try {
            //加载驱动
            Class.forName(ClockInConstants.DRIVER);
            //获取连接
            con = DriverManager.getConnection(ClockInConstants.URL, ClockInConstants.USER, ClockInConstants.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接
     */
    public static void closeCon() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     *
     * @return
     */
    public static int executeUpdate(String sql, Object... params) {
        int i = 0;
        //获取连接
        con = getCon();
        if (con != null) {
            try {
                pstm = con.prepareStatement(sql);
                //设置参数
                if (params.length > 0 && params != null) {
                    for (int j = 0; j < params.length; j++) {
                        pstm.setObject((j + 1), params[j]);
                    }
                }
                //更新数据
                i = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeCon();
            }
        }
        return i;
    }

    public static <T> List<T> executeQuery(String sql, Class clazz, Object... params) {
        List<T> list = new ArrayList<>(10);
        //获取连接
        con = getCon();
        if (con != null) {
            try {
                pstm = con.prepareStatement(sql);
                //设置参数
                if (params.length > 0 && params != null) {
                    for (int j = 0; j < params.length; j++) {
                        pstm.setObject((j + 1), params[j]);
                    }
                }
                //执行查询
                rs = pstm.executeQuery();
                //获取元数据
                ResultSetMetaData metaData = rs.getMetaData();
                //获取列数
                int columnCount = metaData.getColumnCount();
                while (rs.next()){//一行一行取数据
                    //创建对象用于接收数据
                    T t = (T) clazz.newInstance();
                    for (int i = 0; i < columnCount; i++) {
                        //获取列名
                        String columnLabel = metaData.getColumnLabel(i);
                        //获取方法名字
                        String methonName = ClassUtil.getClassName(columnLabel);
                        //获取数据类型
                        Class aClass = ClassUtil.getClass(methonName);
                        //反射填充,获取方法
                        Method method = clazz.getMethod(methonName, aClass);
                        //获取值
                        Object objectVal = rs.getObject(columnLabel);
                        //将值存入对象
                        method.invoke(t,objectVal);
                    }
                    //将数据添加到集合中
                    list.add(t);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}