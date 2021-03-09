package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.Person1;
import com.java.wxg.demo.bean.Student;
import com.java.wxg.demo.bean.Teacher;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-15:21
 * @Since:jdk1.8
 * @Description:TODO
 */
public class PersonTest {

    public void getAge(Person1 person){
        System.out.println("年龄是："+person.getAge());
    }

    public static void main(String[] args) {
        Person1 p1 = new Person1();
        Student s1 = new Student();
        Teacher t1 = new Teacher();
    }
}