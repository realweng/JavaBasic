package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-19:02
 * @Since:jdk1.8
 * @Description:作业1
 */

import java.util.Scanner;

/**
 * 3.用户从控制台输入一个字符串，
 * 请判断是否为回文字符串。【回文字符串：正着读和反着读都是一样的】。
 * 使用String和StringBuilder两种方式实现。
 */
public class HomeWork1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串：");
        //用String来做
//        String str1 = sc.next();
//        char charStr1[] = str1.toCharArray();
//        for (int i = 0; i < charStr1.length/2; i++) { //逆序
//            char temp =charStr1[i];
//            charStr1[i] = charStr1[charStr1.length-1-i];
//            charStr1[charStr1.length-1-i] = temp;
//        }
//        String str2 = new String(charStr1);
//        System.out.println(str1);
//        System.out.println(str2);
//        if(str1.equals(str2)){
//            System.out.println("您输入的字符串是回文字符串");
//        }else
//            System.out.println(str1+"不是回文字符串");

        //用StringBuilder来做
        StringBuilder stringBuilder = new StringBuilder(sc.next());
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse());
        String str1 = stringBuilder.toString();
        String str2 = stringBuilder.reverse().toString();
        if(str1.equals(str2)){
            System.out.println("是回文字符串");
        }else
            System.out.println("不是回文字符串");
    }
}