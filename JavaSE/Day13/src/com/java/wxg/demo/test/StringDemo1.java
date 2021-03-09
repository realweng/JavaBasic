package com.java.wxg.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-16:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StringDemo1 {
    public static void main(String[] args) {
//        String str1 = new String();
//        if(str1.equals("")){
//            System.out.println("这是一个空字符串！");
//        }
//
//        String str2 = new String("abc");
//        System.out.println(str2);
//        char value[] = {'a','b','c','d','e','f'};
//        String str3 = new String(value);
//        System.out.println(str3);
//
//        byte[] bytes = {66,67,68,69};
//        String str4 = new String(bytes);
//        System.out.println(str4);
//
//        String str5 = "测试";
//        byte values [] = str5.getBytes();
//        System.out.println(values.toString());

        String str6 = "abcdafdsf";
        char ch = 'd';
        char []chars = str6.toCharArray();
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if(ch == chars[i]){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("没有找到！");
        }else
            System.out.println("找到了！位置："+index);

        int index1 = str6.indexOf(ch);
        if(index1 == -1){
            System.out.println("没有找到！");
        }else
            System.out.println("找到了！位置："+index1);
    }
}