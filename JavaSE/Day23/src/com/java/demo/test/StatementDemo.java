package com.java.demo.test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-15:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StatementDemo {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
    private static final String user = "root", password = "admin";

    /**
     * 连接
     */
    public Connection getCon() {
        Connection con = null;
        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, user, password);
                if (con != null) {
                    System.out.println("连接成功");

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 插入
     */
    public void addUser() {
        Connection con = getCon();
        Statement stm = null;
        if (con != null) {
            try {
                stm = con.createStatement();
                String sql = "insert into tb_user VALUES(10,'cat1','男',19,'USA')";
                int i = stm.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("插入成功！");
                } else
                    System.out.println("插入失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                conClose(con,stm);
            }
        }
    }

    /**
     * 修改
     */
    public void updateUser() {
        Connection con = getCon();
        Statement stm = null;
        if (con != null) {
            try {
                stm = con.createStatement();
                String sql = "update tb_user set userGender = '男' where userId = 2";
                int i = stm.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("修改成功！");
                } else
                    System.out.println("修改失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                conClose(con,stm);
            }
        }
    }

    /**
     * 删除
     */
    public void delUser() {
        Connection con = getCon();
        Statement stm = null;
        if (con != null) {
            try {
                stm = con.createStatement();
                String sql = "delete from tb_user where userId = 4";
                int i = stm.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("删除成功！");
                } else
                    System.out.println("删除失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                conClose(con,stm);
            }
        }
    }

    /**
     * 关闭；连接
     *
     * @param con
     */
    public void conClose(Connection con, Statement stm) {
        try {
            if(stm != null){
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 程序的入口，测试
     *
     * @param args
     */
    public static void main(String[] args) {
        new StatementDemo().addUser();
        new StatementDemo().delUser();
    }
}