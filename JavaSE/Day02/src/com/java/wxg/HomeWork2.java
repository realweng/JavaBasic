package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork2 {
    public static void main(String[] args) {
        /*
        商场实行新的抽奖规则：会员号的百位数字等于产生的随机数字即为幸运会员。实现：
        1、从键盘接收4位数会员号
        2、生成随机数
         int random = (int) (Math.random() * 10);
        3、算出会员号中在百位的数字号码
         int baiwei = custNo / 100 % 10;
        使用if-else实现幸运抽奖
         */
        Scanner sc = new Scanner(System.in);
        int vipNum = sc.nextInt();
        int bai;
        bai = (vipNum%1000)/100;
        int random = (int) (Math.random() * 10);
        if(bai == random){
            System.out.println("恭喜中奖");
        }else
            System.out.println("未中奖，下次好运！");

    }
}