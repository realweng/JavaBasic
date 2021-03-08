package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-15:12
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo3 {

    static Scanner sc = new Scanner(System.in);

    /**
     * 获取长方形的面积
     */
    public static void gerArea(){
        System.out.println("请输入长方形的长与宽：");
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        System.out.println("长方形的面积为："+h1*h2);
    }

    /**
     * 获取长方形的周长
     */
    public static void gerLang(){
        System.out.println("请输入长方形的长与宽：");
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        System.out.println("长方形的周长为："+2*(h1+h2));
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("1.求面积   2.求周长");
        int n = sc.nextInt();
        switch (n){
            case 1:
                gerArea();
                break;
            case 2:
                gerLang();
                break;
            default:
                break;
        }
    }
}