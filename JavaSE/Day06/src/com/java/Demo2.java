package com.java;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-15:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo2 {

    /**
     * 基本数据类型
     * @param num
     */
    public static void setNum(int num){
        num = 100;
    }

    /**
     * 引用数据类型
     * @param num
     */
    public static void setNums(int num[]){
        num[0] = 100;
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        int num = 2;  //基本数据类型只有在数据被覆盖后才会改变其值
        setNum(num);
        System.out.println(num);
        int nums[] = {1,2,3};
        setNums(nums);
        System.out.println(Arrays.toString(nums));
    }
}