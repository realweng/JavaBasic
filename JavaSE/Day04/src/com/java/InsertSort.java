package com.java;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-17:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class InsertSort {
    public static void main(String[] args) {
        int []num = {19,2,17,35,9,91};
        int j;
        for (int i = 1; i < num.length - 1; i++) {
            //获取当前的值
            int n = num[i];   //从第二个数开始

            for (j = i - 1; j >= 0 ; j--) {
                if(n < num[j]){
                    //往右移动
                    num[j+1] = num[j];
                }else
                    break;
            }
            //空位置，当前比较的这个值索引的后一个空位置
            num[j+1] = n;
        }
        System.out.println(Arrays.toString(num));
    }
}