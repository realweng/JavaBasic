package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-17:57
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork4 {
    public static void main(String[] args) {
        //循环录入Java考试的成绩，求出分数大于80以及小于60分所占的比例为多少？
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要录入的人数：");
        int n = sc.nextInt();
        int cnt = 1,cnt1 = 0,num = 0;
        while (cnt <= n){
            System.out.println("请输入第"+cnt+"个同学的Java成绩：");
            num = sc.nextInt();
            if(num > 80 || num < 60){
                cnt1++;
            }
            cnt++;
        }
        System.out.println("分数大于80以及小于60分所占的比例为" + ((double)cnt1 / (double) n)*100 + "%");
    }
}