package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-15:10
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        判断分数等级
        大于90 ----优秀
        70-90 -----良好
        60-70 -----及格
        小于60 ----不及格
         */
        System.out.println("请输入一个分数");
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score < 90 && score >= 70) {
            System.out.println("良好");
        } else if (score < 70 && score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        /*
        通过月份判断季节
        3-5 春
        6-8 秋
        9-11 夏
        12-2 冬
         */
        System.out.println("请输入一个月份1-12");
        int month = sc.nextInt();
        if (month >= 1 && month <= 12) {
            if (month >= 3 & month <= 5) {
                System.out.println("春季");
            } else if (month >= 6 && month <= 8) {
                System.out.println("夏季");
            } else if (month >= 9 && month <= 11) {
                System.out.println("秋季");
            } else {
                System.out.println("冬季");
            }
        } else
            System.out.println("输入错误");

        //通过输入三边的长度判断能不能构成三角形
        System.out.println("请输入三角形三边：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a > 0 && b > 0 && c > 0) {
            if (a + b > c && a + c > b && b + c > a) {
                System.out.println("a、b、c三边能构成三角形");
            }
        } else {
            System.out.println("不能构成三角形");
        }

        //QQ登录模拟
        System.out.println("请输入QQ号码");
        String qq = sc.next();
        if(qq.equals("123")){
            System.out.println("请输入密码：");
            String mm = sc.next();
            if(qq.equals("123") && mm.equals("123")){
                System.out.println("qq和密码输入正确登录成功");
            }else
                System.out.println("密码输入错误");
        }else
            System.out.println("用户不存在");

    }
}