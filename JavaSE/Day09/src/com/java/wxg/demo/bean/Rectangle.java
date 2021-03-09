package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-17:27
 * @Since:jdk1.8
 * @Description:长方形
 */
public class Rectangle extends Shape{
    private double height;
    private double width;

    public void area(){
        System.out.println("长方形的面积："+height*width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}