package com.java.homework.test;

import com.java.homework.bean.BlackPrinter;
import com.java.homework.bean.ColorPrinter;
import com.java.homework.bean.Printer;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:30
 * @Since:jdk1.8
 * @Description:作业1 打印机测试类
 */
public class PrinterTest {
    public static void main(String[] args) {
        Printer p1 = new ColorPrinter(); //彩色打印机的对象
        Printer p2 = new BlackPrinter(); //黑白打印机的对象
        p1.print();
        p2.print();
    }
}