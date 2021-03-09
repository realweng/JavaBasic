package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:25
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork15 {
    public static void main(String[] args) {
        /*
        从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数N:");
        int n = sc.nextInt();
        int sum = 0,cnt = 0;
        for (int i = 1;i <= n;i++){
            if(i % 7 == 0){
                cnt++;
                sum += i;
            }
        }
        System.out.println("1到"+n+"能被7整除的个数为："+cnt);
        System.out.println("这些数的和是："+sum);
    }
}