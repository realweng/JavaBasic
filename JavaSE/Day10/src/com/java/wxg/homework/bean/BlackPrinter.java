package com.java.wxg.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:25
 * @Since:jdk1.8
 * @Description:作业1 黑白打印机
 */
public class BlackPrinter extends Printer{
   private String makeAddress;//产地

    @Override
    public void print() {
        System.out.println("黑白打印机不能双面打印！");
    }
}