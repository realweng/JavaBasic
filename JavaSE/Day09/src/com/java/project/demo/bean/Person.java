package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-11:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Person {
    private String name;

    public void eat(Apple apple){
        apple.appleEat();
        System.out.println(name+"在吃苹果");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}