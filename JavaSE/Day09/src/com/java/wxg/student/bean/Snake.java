package com.java.wxg.student.bean;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-21:20
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data

public class Snake extends Animal{
    /**
     * 蛇走的方法
     */
    public void run(){
        System.out.println("蛇在地上爬");
    }
}