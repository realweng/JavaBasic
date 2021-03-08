package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork4 {
    public static void main(String[] args) {
        /*
        小林子买了一筐鸡蛋，如果坏蛋少于5个，他就吃掉，否则他就去退货。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入坏蛋的个数：");
        int num = sc.nextInt();
        if(num < 5){
            System.out.println("坏蛋少于5，吃掉");
        }else
            System.out.println("退货！");
    }
}