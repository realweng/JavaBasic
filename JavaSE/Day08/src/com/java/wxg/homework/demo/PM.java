package com.java.wxg.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:55
 * @Since:jdk1.8
 * @Description:产品经理类
 */
public class PM {
    private String id;      //员工编号
    private String name;    //姓名
    private char gender;    //性别
    private double salary;  //工资
    private String exp;     //项目经验
    private double bonus;   //项目分红

    /**
     * 无参构造器
     */
    public PM() {

    }

    /**
     * 有参构造器
     */
    public PM(String id, String name, char gender, double salary, String exp, double bonus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.exp = exp;
        this.bonus = bonus;
    }

    /**
     * 产品经理信息展示方法
     */
    public void show(){
        System.out.println("员工编号："+this.id);
        System.out.println("姓名："+this.name);
        System.out.println("性别："+this.gender);
        System.out.println("工资："+this.salary);
        System.out.println("项目经验："+this.exp);
        System.out.println("项目分红："+this.bonus);
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}