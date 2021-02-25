package com.java.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:21
 * @Since:jdk1.8
 * @Description:作业4
 */

/**
 * 要求写一个工具类，可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
 */
public class HomeWork4 {
    /**
     * 可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
     */
    public static void randomString(int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int ranSelect = (int)(Math.random()*3); //0 产生一个数字 1产生一个a-z的字符 2产生一个A-Z的字符
            switch (ranSelect){
                case 0:
                    int random = (int)(Math.random()*10); //产生0-9的数字
                    char num =(char)(random+48);          //+48到达对应的ASCII码值
                    stringBuilder.append(num);
                    break;
                case 1:
                    int random1 = (int)(Math.random()*26); //产生0-25的数字
                    char AZ =(char)(random1+65);           //+65到达对应的ASCII码值
                    stringBuilder.append(AZ);
                    break;
                case 2:
                    int random2 = (int)(Math.random()*26); //产生0-25的数字
                    char az =(char)(random2+97);           //+65到达对应的ASCII码值
                    stringBuilder.append(az);
                    break;
            }
        }
        System.out.println("随机"+n+"个字符串为："+stringBuilder.toString());
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        randomString(5);
    }
}