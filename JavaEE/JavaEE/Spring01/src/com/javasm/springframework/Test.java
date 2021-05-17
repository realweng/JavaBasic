package com.javasm.springframework;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/29-20:48
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Test {
    public static void main(String[] args) {
        Integer i1 = -128;
        Integer i2 = -128;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3.equals(i4));
    }

}