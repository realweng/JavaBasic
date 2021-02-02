package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-19:46
 * @Since:jdk1.8
 * @Description:作业3
 */

import java.util.Arrays;

/**
 * 5.把数组中的数据按照指定格式拼接成一个字符串。
 *  举例：int[] arr = {1,2,3};	输出结果：[1, 2, 3]
 */
public class HomeWork3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(change(arr));
    }
    public static String change(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}