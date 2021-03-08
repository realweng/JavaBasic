package com.java.project.homework.demo;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:50
 * @Since:jdk1.8
 * @Description:作业3 彩色打印机
 */
@Data
public class ColorPrinters extends Printer {
    /**
     * 扫描的方法
     */
    public void scan() {
        System.out.println("彩色打印机正在扫描");
    }
}