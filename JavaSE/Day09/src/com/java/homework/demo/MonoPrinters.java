package com.java.homework.demo;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:50
 * @Since:jdk1.8
 * @Description:作业3 黑白打印机
 */
@Data

public class MonoPrinters extends Printer {
    /**
     * 显示的功能
     */
    public void show() {
        System.out.println("黑白打印机正在显示");
    }
}