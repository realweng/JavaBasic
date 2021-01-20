package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:22
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork12 {
    public static void main(String[] args) {
        //计算用户输入的日期离1900年1月1日相距多少天

        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入年月日：");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int cnt = 0;
        if(year >= 1900){
            System.out.print("在1900年1月1日之后的：");
                int count1 = 0,count2 = 0;
                year = year - 1; //扣除当年的一整年
                for(;year >= 1900;year--){
                    if((year%4 == 0 && year%100 != 0) || year % 400 == 0){
                        count1++; //闰年数计数器
                    }else
                        count2++; //平年计数器
                }
               // System.out.println("闰年数"+count1+" "+"平年数"+count2);
                switch (month){
                    case 12:
                        cnt+=30;
                    case 11:
                        cnt+=31;
                    case 10:
                        cnt+=30;
                    case 9:
                        cnt+=31;
                    case 8:
                        cnt+=31;
                    case 7:
                        cnt+=30;
                    case 6:
                        cnt+=31;
                    case 5:
                        cnt+=30;
                    case 4:
                        cnt+=31;
                    case 3:
                        if((year%4 == 0 && year % 100 != 0) || year % 400 == 0){
                            cnt+=29;
                        }else
                            cnt+=28;
                    case 2:
                        cnt+=31;
                    case 1:
                        cnt+=0;
                    default:
                        break;
                }
                cnt += day;
                cnt += 366*count1 + 365*count2;
                System.out.println((cnt-1)+"天");

        }else {
            int cnt1 = 0;
            System.out.print("在1900年之前的：");
                //判断1900年之前的情况
                int count1 = 0,count2 = 0;
                year = year + 1; //扣除当年的一整年
                for(;year < 1900;year++){
                    if((year%4 == 0 && year%100 != 0) || year % 400 == 0){
                        count1++; //闰年数计数器
                    }else
                        count2++; //平年计数器
                }
              //  System.out.println("闰年数"+count1+" "+"平年数"+count2);
                switch (month){
                    case 1:
                        cnt1=cnt1-day+31;
                        day = 0;//置零，下同
                    case 2:
                        if((year%4 == 0 && year%100 != 0) || year % 400 == 0){
                            cnt1=cnt1-day+29;
                        }
                        cnt1=cnt1-day+28;
                        day = 0;
                    case 3:
                        cnt1=cnt1-day+31;
                        day = 0;
                    case 4:
                        cnt1=cnt1-day+30;
                        day = 0;
                    case 5:
                        cnt1=cnt1-day+31;
                        day = 0;
                    case 6:
                        cnt1=cnt1-day+30;
                        day = 0;
                    case 7:
                        cnt1=cnt1-day+31;
                        day = 0;
                    case 8:
                        cnt1=cnt1-day+31;
                        day = 0;
                    case 9:
                        cnt1=cnt1-day+30;
                        day = 0;
                    case 10:
                        cnt1=cnt1-day+31;
                        day = 0;
                    case 11:
                        cnt1=cnt1-day+30;
                        day = 0;
                    case 12:
                        cnt1=cnt1-day+31;
                        day = 0;
                    default:
                        break;
                }
                cnt1 = count1*366 + count2*365 + cnt1;
                System.out.println((cnt1+1)+"天");

        }
    }
}