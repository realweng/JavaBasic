package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork18 {
    public static void main(String[] args) {
        /*
        求出1-100之间的素数/质数？【质数又称素数。一个大于1的自然数，除了1和它自身外，
        不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。】
         */

        for(int i = 1;i <= 100;i++){
            boolean flag = true;
            for (int j = 2;j <= i/2;j++){
                if(i < 3){
                    flag = true;
                    continue;
                }else if(i % j == 0){
                    //不是质数
                    flag = false;
                    continue;
                }
            }
            if(flag){
                System.out.println(i);
            }

        }

    }
}