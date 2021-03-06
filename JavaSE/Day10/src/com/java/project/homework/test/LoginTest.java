package com.java.project.homework.test;

import com.java.project.homework.demo.LoginImpl;
import com.java.project.homework.demo.Person;
import com.java.project.homework.demo.Student;
import com.java.project.homework.demo.Teacher;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:46
 * @Since:jdk1.8
 * @Description:作业2 测试类
 */
public class LoginTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        LoginImpl loginTest = new LoginImpl();
        Person p1 = new Student(); //创建一个学生对象
        Person p2 = new Teacher(); //创建一个教师对象
        loginTest.login(p1);       //学生登录测试
        loginTest.login(p2);       //教师登录测试
    }
}