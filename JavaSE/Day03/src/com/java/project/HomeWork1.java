package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-17:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork1 {
    public static void main(String[] args) {
        //输入三个数字，将这三个数字进行排序。【if练习】
        System.out.println("请输入三个数字进行排序：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a > b && a > c){
            System.out.print(a+" ");
            if(b > c){
                System.out.println(b+" "+c);
            }else
                System.out.println(c+" "+b);
        }else if(b > a && b > c){
            System.out.print(b+" ");
            if(a > c){
                System.out.println(a+" "+c);
            } else
                System.out.println(c+" "+a);
        }else {
            System.out.print(c+" ");
            if(a > b){
                System.out.println(a+" "+b);
            }else
                System.out.println(b+" "+a);
        }
    }
}