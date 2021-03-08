package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-15:20
 * @Since:jdk1.8
 * @Description:教师类
 */
public class Teacher extends Person1{
    private String teaNum; //工号

    public void teach(){
        System.out.println("教学");
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }
}