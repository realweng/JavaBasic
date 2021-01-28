package com.javasm.action.impl;

import com.javasm.action.StudentAction;
import com.javasm.bean.Number;
import com.javasm.bean.Student;

import java.util.Arrays;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/1/28-10:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentActionImpl implements StudentAction {
    @Override
    public Number[] findNumberByStudentName(String name, Student[] students) {
        Number[] returnNumber = null;
        //将学生遍历
        for (Student student : students) {
            if (student.getName().equals(name)) {
                //找到了这个学生？？？
                returnNumber = student.getNumbers();
            }
        }
        return returnNumber;
    }

    @Override
    public void showStudentNumber(String name, Student[] students) {
        //根据姓名查找对应的成绩
        Number[] numbers = findNumberByStudentName(name, students);
        //拿到一个返回值之后，不要着急用。先判断
        if (numbers != null) {
            //显示
            int sum = 0, count = 0;
            for (Number number : numbers) {
                //计算总成绩、及格的门数
                sum += number.getNum();
                if (number.getNum() >= 60) {
                    count++;
                }
            }
            System.out.println("总成绩：" + sum + "一共及格了" + count + "门！");
        } else {
            System.out.println("该学生没有考试！");
        }
    }

    @Override
    public void showAllStudent(Student[] students) {
        for (Student student : students) {

        }
    }

    @Override
    public void addStudent(Student[] students, Student student) {
        //？
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
    }
}
