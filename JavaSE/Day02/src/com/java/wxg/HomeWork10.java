package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork10 {
    public static void main(String[] args) {
        /*
        已知2019年1月1日是星期二，从键盘输入2019年的任意一天，请判断它是星期几？
        需要验证是否输入的是2019年？
        要验证月份和日是否是合理输入
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入年月日");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int week = 0;
       // String weekStr = null;
        if(year == 2019){
            switch (month){
                case 1:
                    if(day >=1 && day <= 31){
                        //
                        week = day % 7 + 1;

                    }else
                        System.out.println("日期输入错误");
                    break;
                case 2:
                    if(day >=1 && day <= 28){
                        //+31
                        week = (day + 31) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 3:
                    if(day >=1 && day <= 31){
                        //+31+28 = 59
                        week = (day + 59) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 4:
                    if(day >=1 && day <= 30){
                        //+31+28+31 = 90
                        week = (day + 90) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 5:
                    if(day >=1 && day <= 31){
                        //+31+28+31+30 = 120
                        week = (day + 120) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 6:
                    if(day >=1 && day <= 30){
                        //+31+28+31+30+31 = 151
                        week = (day + 151) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 7:
                    if(day >=1 && day <= 31){
                        //+31+28+31+30+31+30 = 181
                        week = (day + 181) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 8:
                    if(day >=1 && day <= 31){
                        //+31+28+31+30+31+30+31 = 212
                        week = (day + 212) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 9:
                    if(day >=1 && day <= 30){
                        //+31+28+31+30+31+30+31+31 = 243
                        week = (day + 243) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 10:
                    if(day >=1 && day <= 31){
                        //+31+28+31+30+31+30+31+31+30 = 273
                        week = (day + 273) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 11:
                    if(day >=1 && day <= 30){
                        //+31+28+31+30+31+30+31+31+30+31 = 304
                        week = (day + 304) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                case 12:
                    if(day >=1 && day <= 31){
                        //+31+28+31+30+31+30+31+31+30+31+30 = 334
                        week = (day + 334) % 7 + 1;
                    }else
                        System.out.println("日期输入错误");
                    break;
                default:
                    System.out.println("月份输入错误");
                    break;
            }
            switch (week){
                case 1:
                    System.out.println("今天是星期一");
                    break;
                case 2:
                    System.out.println("今天是星期二");
                    break;
                case 3:
                    System.out.println("今天是星期三");
                    break;
                case 4:
                    System.out.println("今天是星期四");
                    break;
                case 5:
                    System.out.println("今天是星期五");
                    break;
                case 6:
                    System.out.println("今天是星期六");
                    break;
                case 7:
                    System.out.println("今天是星期日");
                    break;
                default:
                    break;
            }

        }else {
            System.out.println("所输入的日期不是2019年份");
        }
    }
}