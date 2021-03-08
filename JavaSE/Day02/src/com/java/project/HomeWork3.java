package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork3 {
    public static void main(String[] args) {
        /*
        会员根据积分享受不同折扣，如下表。使用多重if结构计算会员折扣
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入会员积分");
        int x = sc.nextInt();
        if(x < 2000){
            System.out.println("享受9折优惠");
        }else if(x >= 2000 && x < 4000){
            System.out.println("享受8折优惠");
        }else if(x >= 4000 && x < 8000){
            System.out.println("享受7折优惠");
        }else if(x >= 8000){
            System.out.println("享受6折优惠");
        }else
            System.out.println("不享受折优惠");
    }
}