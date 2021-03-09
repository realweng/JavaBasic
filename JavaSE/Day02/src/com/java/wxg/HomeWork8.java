package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:44
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork8 {
    public static void main(String[] args) {
        /*
        输入一个年份，判断是不是闰年？
        普通闰年：公历年份是4的倍数的，且不是100的倍数，为普通闰年（如2004年、2020年就是闰年）。
        世纪闰年：公历年份是整百数的，必须是400的倍数才是世纪闰年（如1900年不是世纪闰年，2000年是世纪闰年）。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        if((year%4 == 0 && year % 100 != 0)|| year % 400 == 0 ){
            System.out.println(year+"年是闰年");
        }else
            System.out.println(year+"年不是闰年");
    }
}