package com.java.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-10:23
 * @Since:jdk1.8
 * @Description:TODO
 */
public class JDBCUtil {
    private static Connection con;
    private static PreparedStatement pstm;
    private static ResultSet rs;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
    public static final String USER = "root", PASSWORD = "admin";
    /**
     * 数据库获取连接
     *
     * @return 返回连接对象
     */
    public static Connection getCon() {
        try {
            //加载驱动
            Class.forName(DRIVER);
            //获取连接
            con = DriverManager.getConnection(URL, USER, PASSWORD);
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
    public static void closeCon(Connection con,PreparedStatement pstm,ResultSet rs) {
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
                closeCon(con,pstm,null);
            }
        }
        return i;
    }
}