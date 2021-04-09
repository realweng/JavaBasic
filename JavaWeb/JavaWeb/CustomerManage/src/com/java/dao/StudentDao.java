package com.java.dao;

import com.java.entity.Student;
import com.java.vo.StudentEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:18
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface StudentDao {
    /**
     * 添加学生
     * @param student
     * @return
     */
    public int addStudent(Student student);

    /**
     * 通过id删学生
     * @param id
     * @return
     */
    public int delStudentById(Integer id);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 查询所有学生信息
     * @return
     */
    public List<StudentEntity> findAllStudent();
}
