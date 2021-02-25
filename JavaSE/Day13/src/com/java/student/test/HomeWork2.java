package com.java.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-19:33
 * @Since:jdk1.8
 * @Description:作业2
 */

import java.util.Arrays;

/**
 * 编写自定义的字符串一致性匹配方法，
 * 只要两个字符串包含同样的字符，不管字符的顺序如何，
 * 都认为两个字符串一致，如：”aabbcc”和”abcabc”被认为是一致的。
 */
public class HomeWork2 {

    public boolean equal(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String ss1 = new String(c1);
        String ss2 = new String(c2);
        if(ss1.equals(ss2)){
            return true;
        }else
        return false;
    }

    public static void main(String[] args) {
        String s1 = new String("aabbcc");
        String s2 = new String("aabcbc");
        HomeWork2 h = new HomeWork2();
        boolean flag = h.equal(s1,s2);
        if(flag){
            System.out.println("一致的字符串");
        }else
            System.out.println("字符串不一致");
    }
}