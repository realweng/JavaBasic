package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-21:59
 * @Since:jdk1.8
 * @Description:学生信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer stuId; //学生编号
    private String stuName;//学生姓名
    private String stuSex;//学生性别
    private String stuAddress;//学生地址
    private String stuClass;//学生所在班级
}