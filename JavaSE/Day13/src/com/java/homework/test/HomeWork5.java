package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-20:00
 * @Since:jdk1.8
 * @Description:作业5
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 去掉一个字符串中的所有空格(包括中间的空格)
 */
public class HomeWork5 {
    /**
     * 去掉字符串中空格的方法
     */
    public static String antiSpace(String s){
        char sc[] = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if(sc[i]==' '){
                for (int j = i; j < sc.length-1; j++) {
                    sc[j] = sc[j+1];
                }
                sc = Arrays.copyOf(sc,sc.length-1);
            }
        }
        String s1 = new String(sc);
        return s1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "123 ab c f";
        System.out.println(antiSpace(s));
    }
}