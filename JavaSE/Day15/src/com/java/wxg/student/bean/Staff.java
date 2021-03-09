package com.java.wxg.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-18:39
 * @Since:jdk1.8
 * @Description:作业2 员工类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
    private String id;          //员工id
    private String name;        //员工姓名
    private double baseSalary;  //基本工资
}