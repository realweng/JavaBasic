package com.homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-18:46
 * @Since:jdk1.8
 * @Description:TODO
 */
    /*
    创建一个有参数的方法。输入两个数字，实现两个数的互换！
     */
public class HomeWork2 {
    static Scanner sc = new Scanner(System.in);

    /**
     * 两个数交换的方法
     * @param num 传入数组的引用
     */
    public static void exchange(int num[]){
        int temp = num[0];
        num[0] = num[1];
        num[1] = temp;
    }

    /**
     * 主函数入口
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请输入两个整数：");
        int num[] = new int[2];
        //交换
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        exchange(num); //引用数据类型，对于基本数据类型初始值只有被覆盖才会变化
        System.out.println(num[0]+" "+num[1]);
    }
}