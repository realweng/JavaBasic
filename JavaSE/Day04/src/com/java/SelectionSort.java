package com.java;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-16:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SelectionSort {
    public static void main(String[] args) {
        int num[] = {3,45,91,1,42,77};
        for (int i = 0;i < num.length;i++){//遍历数组
            int miniIndex = i,maxIndex = i;
            for (int j = i; j < num.length; j++) {
                if(num[miniIndex] > num[i]){
                    int temp = num[i];
                    num[i] = num[miniIndex];
                    num[miniIndex] = temp;
                }
            }
        }
        System.out.println("由小到大"+ Arrays.toString(num));

//        for (int i = 0;i < num.length;i++){//遍历数组
//            int maxIndex = i;
//            for (int j = i; j < num.length; j++) {
//                if(num[maxIndex] < num[i]){
//                    int temp = num[i];
//                    num[i] = num[maxIndex];
//                    num[maxIndex] = temp;
//                }
//            }
//        }
//        System.out.println("由大到小"+ Arrays.toString(num));

    }
}