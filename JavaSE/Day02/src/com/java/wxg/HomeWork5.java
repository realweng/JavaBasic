package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:22
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork5 {
    public static void main(String[] args) {
        /*
        使用多重if和switch…case两种方式实现以下案例：
        录入一个数字，判断今天是星期几？然后根本星期几，吃什么？
        周一：今天是周一，我们吃西红柿炒番茄')
        周二：今天是周二，我们吃马铃薯炖土豆')
        周三：今天是周三，我们吃大米蒸小米')
        周四：今天是周四，我们吃老母鸡炖小母鸡')
        周五：今天是周五，我们吃杏孢菇拌金针菇'）
        周六、周日：今天是周天，食堂不开饭饿着！')
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个1-7的数");
        int num = sc.nextInt();
        switch(num){
            case 1:
                System.out.println("今天是周一，我们吃西红柿炒番茄')");
                break;
            case 2:
                System.out.println("今天是周二，我们吃马铃薯炖土豆')");
                break;
            case 3:
                System.out.println("今天是周三，我们吃大米蒸小米')");
                break;
            case 4:
                System.out.println("今天是周四，我们吃老母鸡炖小母鸡')");
                break;
            case 5:
                System.out.println("今天是周五，我们吃杏孢菇拌金针菇'）");
                break;
            case 6:
                System.out.println("周日：今天是周天，食堂不开饭饿着！')");
                break;
            case 7:
                System.out.println("周日：今天是周天，食堂不开饭饿着！')");
                break;
            default:
                break;
        }
    }
}