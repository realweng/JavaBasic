package com.java.wxg.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-10:08
 * @Since:jdk1.8
 * @Description:成绩类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Grade {
    private String subject;
    private double grade;
}