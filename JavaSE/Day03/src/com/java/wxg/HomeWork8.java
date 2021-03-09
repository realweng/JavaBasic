package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-19:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork8 {
    public static void main(String[] args) {
        /*
        请输出以下结果
        2*5 = 10
        4*10 = 40
        6*15 = 90
        ...
        ?*100 = ?
         */
        int m,n;
        for (int i = 1;i <= 20;i++){
                m = 2 * i;
                n = 5 * i;
                System.out.println(m+"*"+n+"="+(m*n));
        }
    }
}