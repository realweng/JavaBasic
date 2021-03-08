package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-15:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Student extends Person1{
    private String stuNum; //学号

    public void study(){
        System.out.println("学生学习");
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }
}