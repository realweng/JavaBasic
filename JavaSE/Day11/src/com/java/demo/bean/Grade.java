package com.java.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-11:26
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Grade {
    private String subject;
    private double grade;
}