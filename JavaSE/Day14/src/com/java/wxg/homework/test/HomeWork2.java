package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-18:58
 * @Since:jdk1.8
 * @Description:作业2
 */

import com.java.wxg.demo.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

/**
 * 定义一个方法，传入两个时间，然后计算两个时间相差几个小时！
 */
public class HomeWork2 {

    /**
     * 计算时间差的方法
     * @param date1
     * @param date2
     */
    public static void dateDistance(Date date1,Date date2){
        long time = Math.abs(date1.getTime() - date2.getTime())/(1000*60*60);
        System.out.println("这两个时间的时间差为："+time+"小时");
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //时间输入格式：yyyy-MM-dd HH:mm:ss
        System.out.println("请输入第一个时间");
        String s1 = scanner.nextLine();
        System.out.println("请输入第二个时间");
        String s2 = scanner.nextLine();
        Date date1 = DateUtil.parseString(s1);
        Date date2 = DateUtil.parseString(s2);
        dateDistance(date1,date2);
    }
}