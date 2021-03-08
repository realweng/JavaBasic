package com.java.project.demo.test;

import com.java.project.demo.bean.Apple;
import com.java.project.demo.bean.Person;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-11:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AppleTest {
    public static void main(String[] args) {
        Person p = new Person();
        Apple apple = new Apple();
        apple.setSize(100);
        p.setName("张三");
        p.eat(apple);
    }
}