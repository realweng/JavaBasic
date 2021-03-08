package com.java.project.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-18:38
 * @Since:jdk1.8
 * @Description:作业10
 */
public class HomeWork10 {
    public static void main(String[] args) {
        String str1 = "我是 翁兴国，英文名是 wxg；来自 安徽省，今年 XX；我的爱好有：XX，XX；我的的联系方式为 ；18326529881";

        System.out.println(str1.contains("湖北省")); //false
        System.out.println(str1.substring(16, 28)); //截取
        System.out.println(str1.substring(0,6));    //截取
        System.out.println(str1.split("；").length);
        for (String s : str1.split("；")) {
            System.out.println(s);                  //分割输出
        }
        int count = 0;
        char charStr1[] = str1.toCharArray();
        for (int i = 0; i < charStr1.length; i++) {
            if(charStr1[i] == '我'){
                count++;
            }
        }
        System.out.println("“我”出现的次数为："+count);
        System.out.println( str1.replace('我','I'));
    }
}