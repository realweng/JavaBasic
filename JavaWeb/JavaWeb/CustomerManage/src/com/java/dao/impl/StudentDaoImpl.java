package com.java.dao.impl;

import com.java.dao.StudentDao;
import com.java.entity.Student;
import com.java.util.JDBCUtil;
import com.java.vo.StudentEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentDaoImpl implements StudentDao {
    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        String sql = "insert into student values(null,?,?,?,?)";
        return JDBCUtil.update(sql,student.getStuName(),student.getStuSex(),student.getStuAddress(),student.getStuClass());
    }

    /**
     * 通过id删学生
     *
     * @param id
     * @return
     */
    @Override
    public int delStudentById(Integer id) {
        String sql = "delete from student where stuId = ?";
        return JDBCUtil.update(sql,id);
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        String sql = "update student set stuName=?,stuSex=?,stuAdress=?,stuClass=? where stuId = ?";
        return JDBCUtil.update(sql,student.getStuName(),student.getStuSex(),student.getStuAddress(),student.getStuClass(),student.getStuId());
    }

    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<StudentEntity> findAllStudent() {
        String sql = "select s.stuId,s.stuName,s.stuSex,s.stuAdress,c.className from student s,classinfo c where s.stuClass=c.classId";
        return JDBCUtil.query(sql,StudentEntity.class);
    }
}