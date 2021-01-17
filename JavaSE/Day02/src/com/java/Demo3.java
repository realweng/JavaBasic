package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/16-20:18
 * @Since:jdk1.8
 * @Description:Scanner
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个整数：");
//        int a = sc.nextInt();
//        System.out.println("输出这个数："+a);
//        //next()在遇到空格就停止接受，nextLine可以正常接受空格字符
//        System.out.println("请输入一个字符串：");
//        String str = sc.nextLine();
//        System.out.println("输出这个字符串：" + str);
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入性别");
        String sex = sc.next();
        System.out.println("请输入年龄：");
        int old = sc.nextInt();
        System.out.println("姓名："+name+" "+"性别："+sex+" "+"年龄："+old);

    }
}