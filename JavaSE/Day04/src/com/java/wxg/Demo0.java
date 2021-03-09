package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-11:13
 * @Since:jdk1.8
 * @Description:数组练习
 */
public class Demo0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生数：");
        int n = scanner.nextInt();
        double []score = new double[n];
        for (int i = 0;i < score.length;i++){
            System.out.println("请输入第"+(i+1)+"个学生的成绩：");
            score[i] = scanner.nextDouble();
        }
        for (int i = 0;i < score.length;i++){
            System.out.println("学生编号"+(i+1)+"的成绩是："+score[i]);
        }
    }
}