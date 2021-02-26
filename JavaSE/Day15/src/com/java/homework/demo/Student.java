package com.java.homework.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-19:05
 * @Since:jdk1.8
 * @Description:作业3 学生类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 实现“学生管理系统”：
 * 添加学生：依次输入学生的：学号、姓名、年龄、性别和联系方式。存入到集合中。
 * 要求学号不允许重复，并且要对联系方式进行加密操作。
 * 显示所有的学生信息。
 * 统计人数：分别统计总人数、男生的占比和女生的占比分别是？
 * 移除学生：移除所有年龄小于18岁的学生信息。
 */
public class Student {
    private String id;      //学生id
    private String name;    //学生姓名
    private Integer age;    //学生年龄
    private String gender;//学生性别
    private String phone;   //学生联系方式
}