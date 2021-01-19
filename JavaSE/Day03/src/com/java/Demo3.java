package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-11:59
 * @Since:jdk1.8
 * @Description:for循环
 */
public class Demo3 {
    public static void main(String[] args) {
        //算钱
        int sum = 1,allSum = 0;
        for (int i = 1;i <= 29;i++){
            sum = sum * 2;
            allSum += sum;
        }
        System.out.println("一共"+(allSum+1)+"元");

        //计算成绩
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float number = 0;     //初始总成绩设置为0
        for (int j = 0;j < n;j++){
            System.out.println("请输入第"+(j+1)+"个学生的分数：");
            number += sc.nextFloat();
        }
        System.out.println("总成绩为:"+number+"\t平均分:"+(number/n));

    }
}