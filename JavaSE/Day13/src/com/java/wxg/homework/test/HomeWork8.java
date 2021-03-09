package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-21:02
 * @Since:jdk1.8
 * @Description:作业8
 */

import java.util.Arrays;

/**
 * 现有一个字符串“woZUIaiAIxueSHAGNbianMAcheng“.将这个字符串
 * 中的大写字母提取出来存入到一个新的字符串中，将小写字母提取
 * 出来存储到一个新的字符串中。然后分别输出！
 */
public class HomeWork8 {
    public static void main(String[] args) {
        String s = "woZUIaiAIxueSHAGNbianMAcheng";
        char sc[] = s.toCharArray();
        char sc1[] = new char[1]; //存放大写字母
        char sc2[] = new char[1]; //存放小写字母
        for (int i = 0; i < sc.length; i++) {
            if (Character.isUpperCase(sc[i])) {//存放大写字母
                sc1[sc1.length - 1] = sc[i];
                sc1 = Arrays.copyOf(sc1, sc1.length + 1);
            } else{//存放小写字母
                sc2[sc2.length - 1] = sc[i];
                sc2 = Arrays.copyOf(sc2, sc2.length + 1);
            }
        }
        String s1 = new String(sc1);
        String s2 = new String(sc2);
        System.out.println(s1);
        System.out.println(s2);
    }
}