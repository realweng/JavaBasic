package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:34
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork7 {
    public static void main(String[] args) {
        //请使用条件结构和三元运算符求3个数的最值。【两种实现】
        //条件结构
        int max = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数a b c");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        max = a;
        /*
        //方法1：
        if(max <= b){
            max = b;
        }
        if(max <= c){
            max = c;
        }
        System.out.println("最大值为："+max);
         */
        //方法2：
        max = (max >= b ) ? max : b;
        max = (max >= c) ? max : c;
        System.out.println("最大值为："+max);
    }
}