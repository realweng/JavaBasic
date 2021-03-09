package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-17:04
 * @Since:jdk1.8
 * @Description:set-get方法
 */
public class Student1 {
    private String name;
    private String stuNum;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setStuNum(String stuNum){
        this.stuNum = stuNum;
    }

    public String getStuNum(){
        return this.stuNum;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}