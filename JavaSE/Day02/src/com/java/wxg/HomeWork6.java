package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork6 {
    public static void main(String[] args) {
        //要求用户输入两个数a、b，如果a能被b整除或a加b大于1000，则输出a，否则输出b。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a、b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if((a % b == 0 && Math.abs(a) > Math.abs(b))  || a + b > 1000){
            System.out.println(a);
        }else
            System.out.println(b);
    }
}