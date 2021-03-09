package com.java.wxg.demo.inter;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-16:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class NumsImpl implements NumsInterface{

    /**
     * 求和
     * @param num
     */
    @Override
    public void sum(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        System.out.println("求和结果为"+sum);
    }

    /**
     * 求奇数的个数
     * @param num
     * @return
     */
    @Override
    public int oddCount(int[] num) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]%2 != 0){
                count++;
            }
        }
        System.out.println("奇数个数为"+count);
        return count;
    }

    /**
     * 使用排序（冒泡排序）
     * @param num
     */
    @Override
    public void sortShow(int[] num) {
        //冒泡排序
        for (int i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length-i-1; j++) {
                if(num[j] < num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        System.out.println("数组排序的结果是"+ Arrays.toString(num));
    }

    /**
     * 求偶数的数组
     * @param num
     * @return
     */
    @Override
    public int[] evenNumber(int[] num) {
        //存放偶数元素到新的数组中
        int evenNums [] = new int[num.length];
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] %2 == 0){
                evenNums[count] = num[i];
                count++;
            }
        }
        evenNums = Arrays.copyOf(evenNums,num.length-count);
        System.out.println("偶数数组"+Arrays.toString(evenNums));
        return evenNums;
    }
}