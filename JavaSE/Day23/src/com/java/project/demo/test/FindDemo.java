package com.java.project.demo.test;

import java.sql.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-16:55
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FindDemo {
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
                pstm.setInt(1, id);
                pstm.setString(2, name);
                pstm.setString(3, gender);
                pstm.setInt(4, age);
                pstm.setString(5, addr);
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
     *
     * @param id
     */
    public void delUser(int id) {
        Connection con = getCon();
        if (con != null) {
            try {
                String sql = "delete from tb_user where userId = ?;";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
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
     * 查询表中的总人数
     */
    public void countAllUser() {
        con = getCon(); //连接
        if (con != null) {
            String sql = "select count(*) from tb_user";
            try {
                pstm = con.prepareStatement(sql);  //预编译sql
                ResultSet rs = pstm.executeQuery(); //查询
                if (rs.next()) {
                    int i = rs.getInt(1);
                    System.out.println("总人数为:" + i);
                } else
                    System.out.println("查询结果为空");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过id查找用户信息
     *
     * @param id
     */
    public void getUserById(int id) {
        con = getCon();
        if (con != null) {
            String sql = "select * from tb_user where userId = ?";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString(2);
                    String gender = rs.getString(3);
                    int age = rs.getInt(4);
                    String addr = rs.getString(5);
                    System.out.println("id："+id+" 姓名："+name+" 性别："+gender+" 年龄："+age+" 地址："+addr);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询所有
     */
    public void FindAll(){
        con = getCon();
        if (con != null) {
            String sql = "select * from tb_user";
            try {
                pstm = con.prepareStatement(sql);

                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String gender = rs.getString(3);
                    int age = rs.getInt(4);
                    String addr = rs.getString(5);
                    System.out.println("id："+id+" 姓名："+name+" 性别："+gender+" 年龄："+age+" 地址："+addr);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //new FindDemo().countAllUser();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要查询的id");
//        int id = scanner.nextInt();
//        new FindDemo().getUserById(id);
        new FindDemo().FindAll();
    }
}