package com.java.wxg.student.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:43
 * @Since:jdk1.8
 * @Description:作业2 学生类
 */
@Data
@NoArgsConstructor

public class Student extends Person{
    /**
     * 有参构造器
     * @param id
     * @param pwd
     */
    public Student(String id, String pwd) {
        super(id, pwd);
    }
}