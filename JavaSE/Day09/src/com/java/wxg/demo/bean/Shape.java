package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-17:21
 * @Since:jdk1.8
 * @Description:
 */
public class Shape {
    private String shapeName;

    public void area(){
        System.out.println(shapeName+"求面积");
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}