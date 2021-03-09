package com.java.wxg.demo.dao;

import com.java.wxg.demo.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-17:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserDAO {
    private static final String driver = "com.mysql.jdbc.Driver"; //驱动
    private static final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";//数据库url
    private static final String user = "root", password = "admin";//数据库用户名密码
    private Connection con; //连接对象
    private PreparedStatement pstm; //行为对象
    private ResultSet rs; //返回结果对象

    /**
     * 数据库连接
     */
    private Connection getCon() {
        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭；连接
     */
    private void conClose() {
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
     * 添加用户
     *
     * @param user
     */
    public void addUser(User user) {
        con = getCon();
        if (con != null) {
            try {
                String sql = "insert into tb_user VALUES(?,?,?,?,?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, user.getUserId());
                pstm.setString(2, user.getUserName());
                pstm.setString(3, user.getUserGender());
                pstm.setInt(4, user.getUserAge());
                pstm.setString(5, user.getUserAddr());
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
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    public User getUserById(int id) {
        con = getCon();//连接数据库
        User user = null;
        if (con != null) {
            String sql = "select * from tb_user where userId = ?";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setUserGender(rs.getString(3));
                    user.setUserAge(rs.getInt(4));
                    user.setUserAddr(rs.getString(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> findAll() {
        List<User> userList = new ArrayList<>(10); //存放用户对象的集合
        con = getCon();//连接数据库
        if (con != null) {
            String sql = "select * from tb_user";
            try {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setUserGender(rs.getString(3));
                    user.setUserAge(rs.getInt(4));
                    user.setUserAddr(rs.getString(5));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}