package com.java.wxg.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:25
 * @Since:jdk1.8
 * @Description:作业1 彩色打印机类
 */
public class ColorPrinter extends Printer {
    private String techType;//技术类型

    @Override
    public void print() {
        System.out.println("彩色打印机双面打印");
    }
}