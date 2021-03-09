package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:13
 * @Since:jdk1.8
 * @Description:作业3
 */

import com.java.wxg.demo.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

/**
 *一个方法，要求传入时间和间隔天数，返回新的日期
 */
public class HomeWork3 {

    /**
     * 要求传入时间和间隔天数，返回新的日期
     * @param date
     * @param days
     */
    public static Date setDate(Date date,int days){
        long time = date.getTime();
        time += days*1000*24*60*60;
        date.setTime(time);
        return date;
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //时间输入格式：yyyy-MM-dd HH:mm:ss
        System.out.println("请输入一个时间");
        String s1 = scanner.nextLine();
        System.out.println("请输入间隔的天数");
        int days = scanner.nextInt();
        Date date = DateUtil.parseString(s1);
        System.out.println(DateUtil.formatDate(setDate(date, days)));
    }
}