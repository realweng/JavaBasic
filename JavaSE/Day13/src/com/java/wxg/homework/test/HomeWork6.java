package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-20:19
 * @Since:jdk1.8
 * @Description:作业6
 */

/**
 * 获取一个字符串中指定子串出现的次数。
 * 比如说“hanbasdnbafllgnbahjnbakqqqqlnbaxi”
 * 在这个字符串中，有几个nba？
 */
public class HomeWork6 {
    /**
     * @param s1 父串
     * @param s2 子串
     * @return 子串出现次数
     */
    public static int countString(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length() - s2.length()+1; i++) {
            if (s1.substring(i, i + s2.length()).equals(s2)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "hanbasdnbafllgnbahjnbakqqqqlnbaxi";
       // String s1 = "1111nba111nba12156bnbabanba";
        String s2 = "nba";
        System.out.println("子串出现的次数：" + countString(s1, s2));
    }
}