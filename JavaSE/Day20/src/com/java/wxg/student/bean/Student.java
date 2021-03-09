package com.java.wxg.student.bean;

import java.io.Serializable;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-16:30
 * @Since:jdk1.8
 * @Description:属性：学号、姓名、性别，包含show（）方法用于显示学生的详细信息
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -795044185916326537L;
    private String id;
    private String pwd;
    private String name;
    private String gender;

    public Student(String id, String pwd, String name, String gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void show(){
        System.out.println("编号："+this.getId()+"\t姓名："+this.getName()+"\t性别："+this.getGender());
    }
}