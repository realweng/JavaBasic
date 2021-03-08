package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/16-17:57
 * @Since:jdk1.8
 * @Description:a++与++a的问题
 */
public class Demo2 {
    public static void main(String[] args) {
        int a = 10,b = 20;
        a++;    //a是10，加完到下一条语句才是11
        a = a++; //a是11的值先赋值给a,所以a还是11，之后再执行+1操作，但是此时并不会把12赋给a
        System.out.println(a); //输出的是上一条a最初被赋的值11
        b= a++ + ++a; //11 + 13(在加++a之前a++的整体是11，执行加++a时a的值是12，然后再++a就是13)
        System.out.println(b);
    }
}