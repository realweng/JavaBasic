package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-15:13
 * @Since:jdk1.8
 * @Description:质数
 */
public class Demo5 {
    public static void main(String[] args) {
        //素数判断：只能被1和自己整除的数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = sc.nextInt();
        boolean isFlag = true;
        for (int i = 2;i < num ;i++){
            if(num % i == 0){
                isFlag = false;
                i = num; //断开循环
            }
        }
        if(isFlag){
            System.out.println(num+"是质数");
        }else
            System.out.println(num+"不是质数");

    }
}