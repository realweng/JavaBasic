package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-18:43
 * @Since:jdk1.8
 * @Description:作业1
 */

import java.util.Scanner;

/**
 * 从命令行输入一个字符串！要求从中随机选择6个字符组成验证码！
 */
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入长度大于6的字符串");
        String s1 = scanner.next();
        if(s1.length()<=6){
            System.out.println("输入的字符串太短了");
            return;
        }
        char chars[] = s1.toCharArray();
        boolean isSelect[] = new boolean[chars.length]; //用于标记该字符是否被抽中
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length()<6){ //判断可能一遍填不满6位的情况就再走一遍
            for (int i = 0; i < chars.length; i++) {
                int random = (int)(Math.random()*2); //随机0、1 1表示该字符被选中，0表示未选中
                if(random==1 && isSelect[i]==false){
                    stringBuilder.append(chars[i]);
                    if(stringBuilder.length()>=6){
                        break;
                    }
                }
            }
        }
        System.out.println("验证码为："+stringBuilder.toString());
    }
}