package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/22-18:34
 * @Since:jdk1.8
 * @Description:TODO
 */

import java.util.Scanner;

/**
 * 输入一行字符，分别统计出其中英文字母、数字和其他字符的个数？
 * 手动输入一个学生的成绩，然后对这个成绩进行加分：20%。然后显示出该学生最终的成绩。
 * 手动输入一个4位数，然后求出各个数字之和。
 * 商场举行周年庆活动，抽几折打几折。先手动输入消费的金额，然后随机产生一个7-9之间的折扣。再将消费的金额*折扣等于最终需要支付的价格！
 * 定义一个数组int [] nums = {20,21,12,15,16}; 然后求出这个数组中最大数字和最小数字对应的索引是多少？
 */
public class HomeWork2 {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        //输入一行字符，分别统计出其中英文字母、数字和其他字符的个数？
        System.out.println("请输入字符串：");
        String s1 = scanner.nextLine();
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;//字母、数字、其他字符的个数
        char chars[] = s1.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            //数字
            if (chars[i] >= 48 && chars[i] <= 57) {
                cnt2++;
            }else if ((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
                cnt1++;
            }else
                cnt3++;
        }
        System.out.println("所输入的字符串中字母个数："+cnt1+" 数字个数："+cnt2+" 其他字符个数："+cnt3);

        //手动输入一个学生的成绩，然后对这个成绩进行加分：20%。然后显示出该学生最终的成绩。
        System.out.println("请输入学生的成绩：");
        double grade = scanner.nextDouble();
        grade = grade + grade*0.2;
        System.out.println(grade);

        //手动输入一个4位数，然后求出各个数字之和。
        System.out.println("请输入一个四位数：");
        int num = scanner.nextInt();
        int a = num/1000;//千
        int b = (num/100)%10;//百
        int c = (num%100)/10;//十
        int d = num%10;//个
        System.out.println((a+b+c+d));
        
        //商场举行周年庆活动，抽几折打几折。先手动输入消费的金额，
        // 然后随机产生一个7-9之间的折扣。再将消费的金额*折扣等于最终需要支付的价格！
        System.out.println("请输入消费金额：");
        double price = scanner.nextDouble();
        double zk = (Math.random()*7+2)/10;
        price = price - price*zk;
        System.out.println(price);
        
        //定义一个数组int [] nums = {20,21,12,15,16}; 
        // 然后求出这个数组中最大数字和最小数字对应的索引是多少？
        int []nums = {20,21,12,15,16};
        int max = nums[0];
        int min = nums[0];
        int minIndex = -1,maxIndex = -1;
        //默认找第一次出现最大值最小值的索引
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIndex = i;
            }
        }
        System.out.println("最大值的索引："+maxIndex+" 最小值的索引："+minIndex);
    }
}