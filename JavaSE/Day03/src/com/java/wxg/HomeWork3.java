package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-17:53
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork3 {
    public static void main(String[] args) {
        //求1到100之间所有能被3整除的整数的和以及个数。
        int cnt = 0;
        for(int i = 1;i <= 100;i++){
            if(i%3==0){
                System.out.println(i+"能被3整除");
                cnt++;
            }
        }
        System.out.println("1-100以内能被3整除的个数有"+cnt+"个");

    }
}