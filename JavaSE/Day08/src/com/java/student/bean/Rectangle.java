package com.java.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:22
 * @Since:jdk1.8
 * @Description:矩形类
 */
public class Rectangle {
    private double height;//矩形的长
    private double wide;  //矩形的宽

    /**
     * 有参构造器
     * @param height
     * @param wide
     */
    public Rectangle(double height, double wide) {
        this.height = height;
        this.wide = wide;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    /**
     * 计算周长的方法
     */
    public void perimeter(){
        double per = (this.height+this.wide)*2;
        System.out.println("矩形的周长为："+per);
    }

    /**
     * 计算面积的方法
     */
    public void area(){
        double area = this.height*this.wide;
        System.out.println("矩形的面积为："+area);
    }
}