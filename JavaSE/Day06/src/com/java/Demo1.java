package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-9:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo1 {

    /**
     * 计算圆的面积
     */
    public static void func1(){
        double r = 10;
        System.out.println("圆1的面积为"+(Math.PI*Math.pow(r,2)));
    }

    /**
     * 计算圆的面积
     * @param r 半径
     */
    public static void func2(double r){
        System.out.println("圆2的周长为"+2*Math.PI*r);
    }

    /**
     * 计算圆的面积、周长
     * @param r 半径
     * @return 返回面积
     */
    public static double func3(double r){
        System.out.println("圆3的周长为"+2*Math.PI*r);
        return Math.PI*Math.pow(r,2);
    }

    /**
     * 计算圆的面积、周长
     * @param r
     * @return返回周长和面积
     */
    public static double[] func4(double r){
        double result[] = new double[2];
        result[0] = 2*Math.PI*r;
        result[1] = Math.PI*Math.pow(r,2);
        return result;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        func1();
        func2(10);
        double x = func3(10);
        System.out.println("圆3的面积为"+x);
        double res[] = new double[2];
        res = func4(10);
        System.out.println("面积："+res[0]+"\t"+"周长："+res[1]);

    }
}