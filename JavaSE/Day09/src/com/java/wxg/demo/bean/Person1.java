package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-15:15
 * @Since:jdk1.8
 * @Description:人类-学生/教师类
 */
public class Person1 {
    private String name;
    private char gemder;
    private int age;

    public void speak(){
        System.out.println("说话");
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGemder() {
        return gemder;
    }

    public void setGemder(char gemder) {
        this.gemder = gemder;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}