package com.java.homework.dao;

import com.java.demo.bean.User;
import com.java.homework.bean.Student;
import com.java.homework.constants.StudentConstants;
import com.java.homework.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-18:58
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentDAO {
    private Connection con;//连接对象
    private PreparedStatement pstm;//行为对象
    private ResultSet rs;//返回结果对象

    /**
     * 连接
     *
     * @return
     */
    private Connection getCon() {
        try {
            Class.forName(StudentConstants.DRIVER);
            con = DriverManager.getConnection(StudentConstants.URL, StudentConstants.USER, StudentConstants.PASSWORD);
            if (con != null) {
                System.out.println("连接成功");
            }
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
     * 添加学生信息。要求学号自动增长
     *
     * @param student
     * @return true添加成功 false添加失败
     */
    public boolean addStu(Student student) {
        con = getCon();
        if (con != null) {
            String sql = "insert into tb_student values(null,?,?,?,?,?)";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, student.getStuName());
                pstm.setInt(2, student.getStuAge());
                pstm.setString(3, student.getStuMajor());
                pstm.setString(4, student.getStuDepart());
                pstm.setString(5, DateUtil.dateToString(student.getStuDate()));
                int i = pstm.executeUpdate();
                if (i > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.conClose();
            }
        }
        return false;
    }

    /**
     * 修改学生信息
     * @param student
     * @return true:修改成功 false:修改失败
     */
    public boolean updateStu(Student student) {
        con = getCon();
        if (con != null) {
            String sql = "update tb_student set stu_name = ?,stu_age = ?,stu_major = ?,stu_depart = ? WHERE stu_id = ?";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, student.getStuName());
                pstm.setInt(2, student.getStuAge());
                pstm.setString(3, student.getStuMajor());
                pstm.setString(4, student.getStuDepart());
                pstm.setInt(5, student.getStuId());
                int i = pstm.executeUpdate();
                if (i > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.conClose();
            }
        }
        return false;
    }

    /**
     * 通过id删除学生信息
     * @param id
     * @return
     */
    public boolean delStuById(int id){
        con = getCon();
        if(con!=null){
            String sql = "DELETE from tb_student WHERE stu_id = ?";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1,id);
                int i = pstm.executeUpdate();
                if(i > 0){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.conClose();
            }
        }
        return false;
    }

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> findAllStu(){
        List<Student> studentList = new ArrayList<>(10);
        con = getCon();
        if(con != null){
            String sql = "SELECT * from tb_student";
            try {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()){
                    Student student = new Student();
                    student.setStuId(rs.getInt(1));
                    student.setStuName(rs.getString(2));
                    student.setStuAge(rs.getInt(3));
                    student.setStuMajor(rs.getString(4));
                    student.setStuDepart(rs.getString(5));
                    student.setStuDate(DateUtil.stringToDate(rs.getString(6)));
                    studentList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.conClose();
            }
        }
        return studentList;
    }

    /**
     * 输入专业名称，查询该专业下有多少人。以及具体的学生信息
     * @param major
     * @return
     */
    public List<Student> findStuByMajor(String major){
        List<Student> list = new ArrayList(2);
        con = getCon();
        if(con!=null){
            String sql = "SELECT * from tb_student where stu_major = ?";
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1,major);
                rs = pstm.executeQuery();
                while (rs.next()){
                    Student student = new Student();
                    student.setStuId(rs.getInt(1));
                    student.setStuName(rs.getString(2));
                    student.setStuAge(rs.getInt(3));
                    student.setStuMajor(rs.getString(4));
                    student.setStuDepart(rs.getString(5));
                    student.setStuDate(DateUtil.stringToDate(rs.getString(6)));
                    list.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}