package com.javasm.action;

import com.javasm.bean.Number;
import com.javasm.bean.Student;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/1/28-10:45
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface StudentAction {
    /**
     * 根据学生的姓名查找对应的成绩
     * @param name 学生的姓名
     * @return 成绩的数组
     */
    public Number[] findNumberByStudentName(String name,Student[] students);

    /**
     * 根据学生的名称显示对应的成绩信息【及格的门数、总分数】
     * @param name
     */
    public void showStudentNumber(String name,Student[] students);

    /**
     * 显示所有的学生成绩信息
     */
    public void showAllStudent(Student[] students);

    /**
     * 添加学生
     * @param students 学生数组集合
     * @param student 要添加的学生
     */
    public void addStudent(Student[] students,Student student);
}
