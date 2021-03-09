package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-17:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork2 {
    public static void main(String[] args) {
        //求1到10之间的阶乘。
        int num = 1;
        for(int i = 10;i > 1;i--){
            num *= i;
        }
        System.out.println(num);
    }
}