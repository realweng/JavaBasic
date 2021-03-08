package com.java.project.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-16:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StringToInt {
    public static void main(String[] args) {
        String str = "123456789";
        int num = 0;
        char temp[] = new char[str.length()];
        temp = str.toCharArray();
        for (int i = 0; i <= temp.length-1 ; i++) {
            if(i == temp.length-1){ //如果是最后一位就不乘10
                num = temp[i]-48+ num;
            }else
            num = (temp[i]-48+ num)*10 ;
        }
        System.out.println(num);
    }
}