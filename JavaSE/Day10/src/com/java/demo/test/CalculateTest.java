package com.java.demo.test;

import com.java.demo.inter.CalculateImpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-16:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CalculateTest {
    public static void main(String[] args) {
        CalculateImpl cli = new CalculateImpl();
        cli.minus(3,2); //减
        cli.sum(5,6);   //加
        cli.multi(3,4); //乘
        cli.divide();   //除
    }
}