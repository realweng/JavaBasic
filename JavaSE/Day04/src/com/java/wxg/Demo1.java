package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-11:13
 * @Since:jdk1.8
 * @Description:数组练习
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生数：");
        int n = scanner.nextInt();
        double []score = new double[n]; //分数数组
        String []name = new String[n];  //姓名数组

        double sum = 0;                 //总成绩

        for (int i = 0;i < score.length;i++){
            System.out.println("请输入第"+(i+1)+"个学生的姓名：");
            name[i] = scanner.next();
            System.out.println("请输入第"+(i+1)+"个学生的成绩：");
            score[i] = scanner.nextDouble();
            sum += score[i];
        }

        double maxNum = score[0],minNum = score[0];
        String maxName = name[0],minName = name[0];

        for(int i = 0;i < n;i++){
            //比较最高分
            if(maxNum < score[i]){
                maxNum = score[i];  //比较获得最大值
                maxName = name[i];
            }

            //比较最低分
            if(minNum > score[i]){
                minNum = score[i];  //比较获得最小值
                minName = name[i];
            }
        }

        for (int i = 0;i < score.length;i++){
            System.out.println("学生姓名"+name[i]+"学生编号"+(i+1)+"的成绩是："+score[i]);
        }
        System.out.println(maxName+"获得全班最高成绩为"+maxNum+"分");
        System.out.println(minName+"获得全班最低成绩为"+minNum+"分");
        System.out.println("所有学生的总成绩为："+sum);
        System.out.println("所有学生的平均成绩为："+(sum/n));
    }
}