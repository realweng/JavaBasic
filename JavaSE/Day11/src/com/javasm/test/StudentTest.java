package com.javasm.test;

import com.javasm.action.StudentAction;
import com.javasm.action.impl.StudentActionImpl;
import com.javasm.bean.Number;
import com.javasm.bean.Student;

import java.util.Scanner;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/1/28-10:51
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentTest {
    private StudentAction studentAction = new StudentActionImpl();

    /**
     * 查找成绩
     */
    public void findNumber(Student[] students,Scanner scanner){
        System.out.println("请输入你要查找的姓名：");
        String name = scanner.next();
        //年龄  性别  ....
        Number[] numberByStudentName = studentAction.findNumberByStudentName(name,students);

        //显示
        for (Number number : numberByStudentName) {
            System.out.println(number.getKemu());
        }

    }

    public void addStudent(Student[] students,Scanner scanner){
        //提醒输入
        System.out.println("请输入姓名：");
        String name = scanner.next();
        //成绩
        System.out.println("请输入科目：");
        String kemu = scanner.next();
        System.out.println("请输入分数：");
        float fenshu = scanner.nextFloat();

        //创建一学生
        Number [] numbers = new Number[1];
        numbers[0] = new Number(kemu,fenshu);
        //
        Student addStu = new Student(name,numbers);

        //action
        studentAction.addStudent(students,addStu);
    }
}
