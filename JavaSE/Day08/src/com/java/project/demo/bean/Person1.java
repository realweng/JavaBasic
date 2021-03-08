package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-10:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Person1 {
    public String name;
    public int age;
    public char gender;
    public boolean isInLove;

    public void exercise(String exe){
        System.out.println("喜欢"+exe);
    }

    public Person1(){
        System.out.println("调用了空参构造器");
    }

    public Person1(String name){
        this.name = name;
    }

    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person1(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person1(String name, int age, char gender, boolean isInLove) {
        //this();
        System.out.println("调用了有参构造器");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isInLove = isInLove;
    }
}