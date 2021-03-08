package com.java.project.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:54
 * @Since:jdk1.8
 * @Description:程序员类
 */
public class SE {
    private String id;      //员工编号
    private String name;    //姓名
    private char gender;    //性别
    private double salary;  //工资
    private int hot;        //关注度

    /**
     * 空参构造器
     */
    public SE() {

    }

    /**
     * 有参构造器
     */
    public SE(String id, String name, char gender, double salary, int hot) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.hot = hot;
    }

    /**
     * 显示程序员所有信息
     */
    public void show(){
        System.out.println("员工编号："+this.id);
        System.out.println("姓名："+this.name);
        System.out.println("性别："+this.gender);
        System.out.println("工资："+this.salary);
        System.out.println("关注度："+this.hot);
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}