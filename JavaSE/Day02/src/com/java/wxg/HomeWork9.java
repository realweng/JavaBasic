package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:48
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork9 {
    public static void main(String[] args) {
          /*
        1.起步3公里以内10元，超过每公里5块钱，不足1公里按照1公里计算
        2.起步3公里以内15元，超过每公里6块钱，不足1公里按照1公里计算
        3.起步3公里以内6元，超过每公里3块钱，不足1公里按照1公里计算
         */
        Scanner input = new Scanner(System.in);
        System.out.println("三种车型1.滴滴打车 2.专车 3.顺风车");
        System.out.println("请选择车型：");
        int choose = input.nextInt();
        double price = 0, km = 0;
        switch (choose) {
            case 1:
                System.out.println("您选择的是1.滴滴打车");
                System.out.println("请输入公里数");
                km = input.nextDouble();
                if (km <= 3) {
                    price = 10;
                } else if(km - (int)km != 0){
                    price = 5 * ((int) (km - 3) + 1) + 10;
                }else
                    price = 5 * (km - 3) + 10;
                break;
            case 2:
                System.out.println("您选择的是2.专车");
                System.out.println("请输入公里数");
                km = input.nextDouble();
                if (km <= 3) {
                    price = 15;
                } else if(km - (int)km != 0){
                    price = 6 * ((int) (km - 3) + 1) + 10;
                }else
                    price = 6 * (km - 3) + 10;
                break;
            case 3:
                System.out.println("您选择的是3.顺风车");
                System.out.println("请输入公里数");
                km = input.nextDouble();
                if (km <= 3) {
                    price = 6;
                } else if(km - (int)km != 0){
                    price = 3 * ((int) (km - 3) + 1) + 10;
                }else
                    price = 3 * (km - 3) + 10;
                break;

            default:
                break;
        }
        System.out.println("车费为："+price+"元");
    }
}