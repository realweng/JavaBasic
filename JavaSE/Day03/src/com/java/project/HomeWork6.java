package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-19:06
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork6 {
    public static void main(String[] args) {
        /*
        要求用户输入一个0到2之间的整数
        如果用户输入0输出“你出的是石头”，
        如果用户输入1就输出“你出的是剪刀”，
        如果用户输入的是2就输出“你出的是布”，
        然后再问是否要继续出拳，
        如果回答“y”就重复以上过程，
        否则结束程序
         */
        Scanner sc = new Scanner(System.in);
        String str = null;
        do{
            System.out.println("请输入0-2的数：");
            int n = sc.nextInt();
            switch (n){
                case 0:
                    System.out.println("你出的是石头");
                    break;
                case 1:
                    System.out.println("你出的是剪刀");
                    break;
                case 2:
                    System.out.println("你出的是布");
                    break;
                default:
                    break;
            }
            System.out.println("请问是否继续y/n");
            str = sc.next();
        }while(str.equals("y"));
    }
}