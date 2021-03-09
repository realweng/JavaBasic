package com.java.wxg.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:28
 * @Since:jdk1.8
 * @Description:学生类
 */

/**
 * 作业2
 * 描述一个学生类，学生具备姓名、学号、性别、三个公共的属性，学生都具备吃饭与学习的行为。
 * 测试类中为学生类的属性赋值、调用学生的方法
 * 描述一个电脑类，具有属性：cpu，网卡，显卡，声卡，内存 方法：上网
 * 描述学生拥有一台电脑
 */
public class Student {
    public String name;   //姓名
    public String stuNum; //学号
    public char gender;   //性别

    /**
     * 学生吃饭的方法
     */
    public void eat(){
        System.out.println("学生吃饭");
    }

    /**
     * 学生学习的方法
     */
    public void study(Computer computer){
        System.out.println("学生用CPU是"+computer.getCpuName()+"的电脑学习");
    }

    public Student(String name, String stuNum, char gender) {
        this.name = name;
        this.stuNum = stuNum;
        this.gender = gender;
    }

}