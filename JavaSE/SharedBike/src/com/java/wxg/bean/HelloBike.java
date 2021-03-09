package com.java.wxg.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:21
 * @Since:jdk1.8
 * @Description:哈罗单车
 */
public class HelloBike extends Bike{
    public HelloBike(int bid, String bname, int status, String borrowTime, String rerurnTime) {
        super(bid, bname, status, borrowTime, rerurnTime);
    }
}