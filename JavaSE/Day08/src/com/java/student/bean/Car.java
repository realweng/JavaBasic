package com.java.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-17:53
 * @Since:jdk1.8
 * @Description:TODO
 */

/**
 * 作业1
 * 使用java来描述车class，车都具备轮子数、颜色 、与跑的行为，
 * Java描述修车厂，修车厂具备，名字、地址、电话三个属性，具备修车的功能行为，
 * 车在跑的时候应该判断是否够四个轮子，如果够四个轮子可以跑起，否则送去修车厂维修。
 */

public class Car {
    private int wheelNums;
    private String color;

    /**
     * 车跑的方法
     */
    public void run(CarFactory cft){
        if(this.wheelNums < 4){
            cft.fixCar(this); //修车厂修这辆车
        }else
            System.out.println("车在跑...");
    }

    public Car(int wheelNums, String color) {
        this.wheelNums = wheelNums;
        this.color = color;
    }

    public Car() {
    }

    public int getWheelNums() {
        return wheelNums;
    }

    public void setWheelNums(int wheelNums) {
        this.wheelNums = wheelNums;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}