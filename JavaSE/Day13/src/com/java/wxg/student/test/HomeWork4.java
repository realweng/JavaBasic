package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-19:56
 * @Since:jdk1.8
 * @Description:作业4
 */

/**
 * 字符串反转。
 * 举例：键盘录入”abc”		输出结果：”cba”
 */
public class HomeWork4 {
    /**
     * 逆转的方法
     *
     * @param s
     * @return
     */
    public static String reverse(String s) {
        char sc[] = s.toCharArray();
        for (int i = 0; i < sc.length / 2; i++) {
            char temp = sc[i];
            sc[i] = sc[sc.length - 1 - i];
            sc[sc.length - 1 - i] = temp;
        }
        String s1 = new String(sc);
        return s1;
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "abcd";
        System.out.println(reverse(s1));
        //方法2
        StringBuilder s2 = new StringBuilder("abcde");
        System.out.println(s2.reverse());
    }
}