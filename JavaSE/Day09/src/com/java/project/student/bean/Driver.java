package com.java.project.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Driver {
    public void driver(Car car){
        System.out.println("司机在驾驶"+car.getColor()+"的"+car.getName()+"车");
        car.run();
    }
}