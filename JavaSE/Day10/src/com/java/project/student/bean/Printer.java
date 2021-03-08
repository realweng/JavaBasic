package com.java.project.student.bean;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:24
 * @Since:jdk1.8
 * @Description:作业1 打印机类
 */
@Data

public abstract class Printer {
    private String shopName;//商品名称
    private String shopId;  //商品编号
    public abstract void print();//打印的抽象方法

    /**
     * 扫描的非抽象方法
     */
    public void scan(){
        System.out.println("打印机扫描");
    }
}