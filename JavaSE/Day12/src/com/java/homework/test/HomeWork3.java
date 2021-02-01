package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:37
 * @Since:jdk1.8
 * @Description:作业3的测试类
 */

import com.java.demo.bean.Student;

/**
 * 编写一个Student类，包含id、name、age等属性，
 * 要求使用System.out.println()打印Student类的对象引用时，输出的为name的值！
 * 判断两个学生是否相等，要求如果学号一致则代表是同一个学生。
 */
public class HomeWork3 {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Student stu1= new Student(101,"张三",20);
        Student stu2 = new Student(101,"张三",21);
        System.out.println(stu2);
        System.out.println(stu1.equals(stu2));
    }
}