package com.java.wxg.homework.test;

import com.java.wxg.homework.demo.BMW;
import com.java.wxg.homework.demo.Driver;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:26
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CarTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Driver d = new Driver();
        BMW bmw = new BMW();
        bmw.setColor("黄色");
        bmw.setWheelNums(4);
        d.driver(bmw);
    }
}