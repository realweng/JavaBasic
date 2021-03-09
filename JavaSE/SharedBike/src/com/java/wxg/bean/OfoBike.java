package com.java.wxg.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:22
 * @Since:jdk1.8
 * @Description:ofo单车
 */
public class OfoBike extends Bike{
    public OfoBike(int bid, String bname, int status, String borrowTime, String rerurnTime) {
        super(bid, bname, status, borrowTime, rerurnTime);
    }
}