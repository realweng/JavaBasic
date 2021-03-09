package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-10:25
 * @Since:jdk1.8
 * @Description:三元运算符水仙花数练习
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入100-999的数字");
        int num = input.nextInt();
        String isShuiXianHua = (num == Math.pow((num/100),3) + Math.pow(((num%100)/10),3) + Math.pow((num%10),3)) ? "是水仙花数" : "不是水仙花数";
        System.out.println(num+isShuiXianHua);
    }
}