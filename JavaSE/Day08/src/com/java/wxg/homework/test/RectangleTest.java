package com.java.wxg.homework.test;

import com.java.wxg.homework.demo.Rectangle;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:28
 * @Since:jdk1.8
 * @Description:矩形的测试类
 */
public class RectangleTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Rectangle r = new Rectangle(20,10);
        r.perimeter();//计算周长
        r.area();     //计算面积
    }
}