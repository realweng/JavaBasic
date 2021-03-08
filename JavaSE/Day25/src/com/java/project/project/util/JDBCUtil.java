package com.java.project.project.util;

import com.java.project.project.constants.ClockInConstants;

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
                //执行
                rs = pstm.executeQuery();
                //获取元数据
                ResultSetMetaData metaData = rs.getMetaData();
                //获取列数
                int columnCount = metaData.getColumnCount();
                //循环取值
                while (rs.next()) {
                    //创建一个对象
                    T object = (T) clazz.newInstance();
                    for (int i = 1; i <= columnCount; i++) {
                        //获取label名称
                        String labelName = metaData.getColumnLabel(i);
                        //获取对应的数据类型
                        String className = metaData.getColumnClassName(i);
                        //再根据label名称获取对应的数据
                        Object objectValue = rs.getObject(labelName);
                        //往对象中赋值
                        ClassUtil.invoke(labelName, className, object, objectValue, clazz);
                    }
                    //将对象存入到集合
                    list.add(object);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } finally {
                //关闭连接
                closeCon();
            }
        }
        return list;
    }

}