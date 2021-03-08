package com.java.project.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:03
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long id;
    private double balance;
    private String password;

    public Account(double balance, String password) throws InterruptedException {
        Date d1 = new Date();
        this.id = d1.getTime(); //通过时间获取自增id
        this.balance = balance;
        this.password = password;
    }
}