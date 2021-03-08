package com.java.project.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:37
 * @Since:jdk1.8
 * @Description:作业5 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private int stuNum; //学号
    private String name; //姓名
    private String id;  //身份证号
    private float grade;//学生成绩
    private Security security;//信息类
}