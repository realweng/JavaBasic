package com.java.service.impl;

import com.java.dao.StudentDao;
import com.java.dao.impl.StudentDaoImpl;
import com.java.entity.Student;
import com.java.service.StudentService;
import com.java.vo.StudentEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    /**
     * 通过id删学生
     *
     * @param id
     * @return
     */
    @Override
    public int delStudentById(Integer id) {
        return studentDao.delStudentById(id);
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    /**
     * 查询所有学生信息
     *
     * @return
     */
    @Override
    public List<StudentEntity> findAllStudent() {
        return studentDao.findAllStudent();
    }
}