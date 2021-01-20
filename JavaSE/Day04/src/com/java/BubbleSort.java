package com.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-15:29
 * @Since:jdk1.8
 * @Description:冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        //冒泡排序Demo
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要进行排序元素的个数");
        int n = scanner.nextInt();
        int []num = new int[n];
        for(int i = 0;i < num.length;i++){
            num[i] = scanner.nextInt();
        }
        //进行冒泡排序从小到大
        for(int i = 0;i < num.length - 1;i++){
            for (int j = 0;j < num.length - 1 -i;j++){
                if(num[j] > num[j+1]){   //如果前面的数比后面的数大就交换数据
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        System.out.println("从小到大"+Arrays.toString(num));

        //冒泡排序从大到小
        for(int i = 0;i < num.length - 1;i++){
            for(int j = 0;j < num.length - 1 -i;j++){
                if(num[j] < num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        System.out.println("从大到小"+Arrays.toString(num));

    }
}