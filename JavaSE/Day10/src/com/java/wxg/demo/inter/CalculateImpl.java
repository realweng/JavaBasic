package com.java.wxg.demo.inter;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-16:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CalculateImpl implements Calculate {

    private Scanner scanner;

    /**
     * 构造器
     */
    public CalculateImpl() {
        scanner = new Scanner(System.in);
    }

    /**
     * 加
     *
     * @param num1
     * @param num2
     */
    @Override
    public void sum(int num1, int num2) {
        System.out.println("加法计算结果为" + (num1 + num2));
    }

    /**
     * 减
     *
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public float minus(int num1, int num2) {
        System.out.println("减法计算结果为" + (num1 - num2));
        return num1 - num2;
    }

    /**
     * 除
     */
    @Override
    public void divide() {
        System.out.println("请输入两个数后进行除法运算");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("除法运算结果为" + ((double)num1 / (double)num2));
    }

    /**
     * 乘
     *
     * @param num1
     * @param num2
     */
    @Override
    public short multi(int num1, int num2) {
        System.out.println("乘法运算结果" + num1 * num2);
        return (short)( num1 * num2);
    }
}