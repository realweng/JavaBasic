package com.homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-18:42
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork3 {
    public static void main(String[] args) {
        /*
        定义一个二维数组，存储每个科目的成绩。
        要求录入几个科目，然后根据科目录入分数。然后求出每个科目的最高分和最低分。
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要录入几个科目：");
        int m = scanner.nextInt();
        double grades[][] = new double[m][];
        double max[] = new double[grades.length]; //每科的最高成绩
        double min[] = new double[grades.length]; //每科的最低成绩
        for (int i = 0; i < grades.length; i++) {
            System.out.println("输入第"+(i+1)+"个科目有多少个成绩记录：");
            int n = scanner.nextInt();   //每个科目有n个学生的成绩记录
            double grade[] = new double[n];
            max[i] = -1;
            min[i] = 999999999;

            for (int j = 0; j < grade.length; j++) {
                System.out.println("输入第"+(i+1)+"个科目的第"+(j+1)+"个成绩：");
                grade[j] = scanner.nextDouble();
                if(max[i] < grade[j]){
                    max[i] = grade[j];
                }
                if (min[i] > grade[j]){
                    min[i] = grade[j];
                }
            }
            grades[i] = grade;
        }
        for (int i = 0; i < grades.length; i++) {
            System.out.println("第"+(i+1)+"科的最高成绩为"+max[i]);
            System.out.println("第"+(i+1)+"科的最低成绩为"+min[i]);
            System.out.println();
        }
    }
}