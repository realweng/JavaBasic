package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-17:22
 * @Since:jdk1.8
 * @Description:圆形
 */
public class Circle extends Shape {
    private double r;

    public void area(){
        System.out.println("求圆的面积:"+Math.pow(this.r,2)*3.14);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}