package com.java.project.demo.test;

import com.java.project.demo.bean.Person1;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-9:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo1 {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.age = 20;
        person.gender = '男';
        person.name = "张三";
        System.out.println("姓名："+person.name+" 性别"+person.gender+" 年龄"+person.age+"  "+person.isInLove);

        Person1 person1 = new Person1("李四",23,'男',true);
        System.out.println(person1.name);
        System.out.println(person1.age);
        System.out.println(person1.gender);
        System.out.println(person1.isInLove);
    }
}