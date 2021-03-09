package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-15:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Student1 {
    private Integer id; //id
    private String name;//名字
    private Integer grade;//成绩

    public Student1(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}