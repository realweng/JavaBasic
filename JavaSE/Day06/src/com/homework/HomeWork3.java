package com.homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-18:53
 * @Since:jdk1.8
 * @Description:TODO
 */
    /*
    定义两个数组，存储商品的名称和价格：
    方法一：实现数据的初始化！【初始化5条数据】
    方法二：实现数据的展示！显示所有的商品信息，包含序号、名称和价格。
    方法三：实现商品的最贵和最便宜的价格运算？【求出最贵的商品和最便宜的商品】
     */
public class HomeWork3 {
    Scanner sc = new Scanner(System.in);

    /**
     * 求出最贵商品与最便宜商品
     */
    public static void maxAndMin(String name[],double price[]){
        double max = price[0];
        double min = price[0];
        int count1 = 0,count2 = 0;
        for (int i = 0; i < price.length; i++) {
            if(max < price[i]){
                max = price[i];
                count1 = i;     //记住最大值的索引
            }
            if (min > price[i]){
                min = price[i];
                count2 = i;     //记住最小值的索引
            }
        }
        System.out.println("价格最贵对应的商品为： "+name[count1]+" 其价格为："+price[count1]+"元");
        System.out.println("价格最便宜对应的商品为："+name[count2]+" 其价格为："+price[count2]+"元");
    }
    /**
     * 显示商品信息
     */
    public static void printCommodity(String name[],double price[]){
        System.out.println("序号  商品  价格");
        for (int i = 0; i < name.length; i++) {
            System.out.print(i+"\t");
            System.out.print(name[i]+"\t");
            System.out.println(price[i]+"\t");
        }
    }
    /**
     * 初始化
     */
    public static void initial() {
        String name[] = {"A","B","C","D","E"};
        double price[] = {10,20,30,40,90};
        printCommodity(name,price);
        maxAndMin(name,price);
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
       initial(); //初始化，程序开始执行
    }
}