package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-17:25
 * @Since:jdk1.8
 * @Description:正方形
 */
public class Squares extends Shape{
    private double length;

    public void area(){
        System.out.println("正方形的面积为："+Math.pow(length,2));
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}