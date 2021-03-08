package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-16:17
 * @Since:jdk1.8
 * @Description: break continue
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.添加 2.删除 3.修改 4.查找 5.退出");
        while (true){
            System.out.println("请输入数字1-5：");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    System.out.println("添加");
                    break;
                case 2:
                    System.out.println("删除");
                    break;
                case 3:
                    System.out.println("修改");
                    break;
                case 4:
                    System.out.println("查找");
                    break;
                case 5:
                    System.out.println("退出");
                    break;
                default:
                    break;
            }
            if(n == 5){
                break;//终止循环
            }
        }
    }
}