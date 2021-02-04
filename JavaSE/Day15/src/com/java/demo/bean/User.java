package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-17:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public class User {
    private String id;
    private String name;
    private int age;
    private char grndar;

    public User(String id, String name, int age, char grndar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grndar = grndar;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGrndar() {
        return grndar;
    }

    public void setGrndar(char grndar) {
        this.grndar = grndar;
    }
}