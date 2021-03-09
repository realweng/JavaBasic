package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.Student;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-17:33
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student(1,"张三",20);
        Student s2 = new Student(1,"张三",20);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.toString());
//        System.out.println(s1.hashCode());
        Integer num1 = new Integer(100);
        Integer num2 = new Integer(100);
        System.out.println(num1 == num2);  //false
        System.out.println(num1.equals(num2)); //true

        int n3 = 100;
        Byte b1 = Byte.valueOf((byte) 10);
        System.out.println(n3 == num1); //true

        Integer num4 = Integer.valueOf(100);
        Integer num5 = 100;
        System.out.println(num4 == num5); //true
        System.out.println(n3 == num4); //true

    }
}