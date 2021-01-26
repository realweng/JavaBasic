package com.java.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:15
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private String color;
    private String name;
    private int wheelNums;

    public void run(){
        System.out.println(name+"汽车在跑");
    }
}