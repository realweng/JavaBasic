package com.java.demo.test;

import com.java.demo.bean.Student1;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-17:09
 * @Since:jdk1.8
 * @Description:set——get方法测试类
 */
public class Demo3 {
    public static void main(String[] args) {
        Student1 student = new Student1();
        student.setName("张三");
        student.setAge(18);
        student.setStuNum("12138");
        System.out.println(student.getName()+"  "+student.getStuNum()+" "+student.getAge());
    }
}