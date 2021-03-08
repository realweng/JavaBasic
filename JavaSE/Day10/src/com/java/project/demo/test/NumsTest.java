package com.java.project.demo.test;

import com.java.project.demo.inter.NumsImpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-17:01
 * @Since:jdk1.8
 * @Description:数组的测试类
 */
public class NumsTest {
    private NumsImpl nil;
    static private int num[];

    public NumsTest() {
        nil = new NumsImpl();
        num = new int[]{1, 2, 33,55,7,8,10,25,48,6};
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        NumsTest nt = new NumsTest();
        nt.nil.evenNumber(num); //奇数个数
        nt.nil.oddCount(num);  //偶数数组
        nt.nil.sortShow(num);  //冒泡排序
        nt.nil.sum(num);       //求和
    }
}