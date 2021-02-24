package com.java.demo.test;

import com.java.demo.action.Action;
import com.java.demo.action.ActionImpl;
import com.java.demo.bean.Student;
import com.java.demo.bean.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-15:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(10);
        students.add(new Student(1,"zs"));
        students.add(new Student(2,"ls"));
        students.add(new Student(3,"we"));

        Action<Student> studentAction = new ActionImpl<>(students);
        List<Student> studentActionAll = studentAction.findAll();
        Student studentActionById = studentAction.getById(1);
        System.out.println(studentActionAll);
        System.out.println(studentActionById);

        List<Teacher> teachers = new ArrayList<>(10);
        teachers.add(new Teacher(4,"zz"));
        teachers.add(new Teacher(5,"ll"));
        teachers.add(new Teacher(6,"mm"));
        System.out.println(teachers);
        Action<Teacher> teacherAction = new ActionImpl<>(teachers);
        List<Teacher> teacherActionAll = teacherAction.findAll();
        System.out.println(teacherActionAll);
    }
}