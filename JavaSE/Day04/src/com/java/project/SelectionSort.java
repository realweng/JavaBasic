package com.java.project;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-16:35
 * @Since:jdk1.8
 * @Description:选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int num[] = {3,45,91,1,42,77};
        for (int i = 0;i < num.length;i++){//遍历数组
            int miniIndex = i;
            for (int j = i; j < num.length; j++) { //遍历
                if(num[miniIndex] > num[j]){
                    int temp = num[j];
                    num[j] = num[miniIndex];
                    num[miniIndex] = temp;
                }
            }
        }
        System.out.println("由小到大"+ Arrays.toString(num));

        for (int i = 0;i < num.length;i++){//遍历数组
            int maxIndex = i;
            for (int j = i; j < num.length; j++) {
                if(num[maxIndex] < num[j]){
                    int temp = num[j];
                    num[j] = num[maxIndex];
                    num[maxIndex] = temp;
                }
            }
        }
        System.out.println("由大到小"+ Arrays.toString(num));

    }
}