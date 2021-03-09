package com.java.wxg.homework.bean;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-18:58
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Student {
    private Integer stuId;//学号
    private String stuName;//姓名
    private Integer stuAge;//年龄
    private String stuMajor;//专业
    private String stuDepart;//院系
    private Date stuDate;//注册时间

    public Student() {
    }

    public Student(String stuName, Integer stuAge, String stuMajor, String stuDepart, Date stuDate) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuMajor = stuMajor;
        this.stuDepart = stuDepart;
        this.stuDate = stuDate;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuDepart() {
        return stuDepart;
    }

    public void setStuDepart(String stuDepart) {
        this.stuDepart = stuDepart;
    }

    public Date getStuDate() {
        return stuDate;
    }

    public void setStuDate(Date stuDate) {
        this.stuDate = stuDate;
    }
}