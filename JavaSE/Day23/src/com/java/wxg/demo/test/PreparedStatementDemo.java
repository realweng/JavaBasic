package com.java.wxg.demo.test;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-16:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class PreparedStatementDemo {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
    private static final String user = "root", password = "admin";

    private Connection con;
    private PreparedStatement pstm;

    /**
     * 连接
     */
    public Connection getCon() {
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
    public void addUser(int id, String name, String gender, int age, String addr) {
        Connection con = getCon();
        if (con != null) {
            try {
                String sql = "insert into tb_user VALUES(?,?,?,?,?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1,id);
                pstm.setString(2,name);
                pstm.setString(3,gender);
                pstm.setInt(4,age);
                pstm.setString(5,addr);
                int i = pstm.executeUpdate();
                if (i > 0) {
                    System.out.println("插入成功！");
                } else
                    System.out.println("插入失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                this.conClose();
            }
        }
    }

    /**
     * 通过id删除用户信息
     * @param id
     */
    public void delUser(int id) {
        Connection con = getCon();
        if (con != null) {
            try {
                String sql = "delete from tb_user where userId = ?;";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1,id);
                int i = pstm.executeUpdate();
                if (i > 0) {
                    System.out.println("删除成功！");
                } else
                    System.out.println("删除失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                this.conClose();
            }
        }
    }

    /**
     * 关闭；连接
     */
    public void conClose() {
        try {
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
     * 修改用户信息
     * @param id
     * @param name
     * @param gender
     * @param age
     * @param addr
     */
    public void updateUser(int id, String name, String gender, int age, String addr) {
        Connection con = getCon();
        if (con != null) {
            try {
                String sql = "insert into tb_user VALUES(?,?,?,?,?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1,id);
                pstm.setString(2,name);
                pstm.setString(3,gender);
                pstm.setInt(4,age);
                pstm.setString(5,addr);
                int i = pstm.executeUpdate();
                if (i > 0) {
                    System.out.println("插入成功！");
                } else
                    System.out.println("插入失败！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                this.conClose();
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入id：");
//        int id = scanner.nextInt();
//        System.out.println("请输入name：");
//        String name = scanner.next();
//        System.out.println("请输入gender：");
//        String gender = scanner.next();
//        System.out.println("请输入age：");
//        int age = scanner.nextInt();
//        System.out.println("请输入addr：");
//        String addr = scanner.next();
//        new PreparedStatementDemo().addUser(id,name,gender,age,addr);
        System.out.println("请输入要删除信息对应的id：");
        int id1 = scanner.nextInt();
        new PreparedStatementDemo().delUser(id1);
    }
}