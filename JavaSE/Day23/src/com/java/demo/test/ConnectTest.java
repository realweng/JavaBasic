package com.java.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-11:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ConnectTest {
    public static void main(String[] args) {
        //连接数据库
        /**
         * 加载数据库的驱动
         * 数据库的连接地址：jdbc mysql 本地地址 端口号：3306 连接到数据库 库名
         * 数据库的账号密码
         */
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
        String user = "root";
        String pwd = "admin";
        try {
            //加载驱动
            Class.forName(driver);
            //连接数据库
            Connection conn = DriverManager.getConnection(url, user, pwd);
            if(conn!=null){
                System.out.println("连接成功！");
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}