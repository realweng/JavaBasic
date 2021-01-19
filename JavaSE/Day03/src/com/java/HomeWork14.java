package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:24
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork14 {
    public static void main(String[] args) {
        //打印出所有的 "水仙花数"
        for(int i = 100;i < 1000;i++){
            if(Math.pow(i/100,3)+Math.pow((i%100)/10,3)+Math.pow(i%10,3) == i){
                System.out.println(i+"是水仙花数");
            }
        }
    }
}