package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-21:59
 * @Since:jdk1.8
 * @Description:班级信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo {
    private Integer classId; //班级编号
    private String className;//班级名称
    private Date classDate;  //班级创建日期
    private String classNote;//班级备注
}