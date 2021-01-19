package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-15:12
 * @Since:jdk1.8
 * @Description:水仙花数
 */
public class Demo4 {
    public static void main(String[] args) {
        //100 - 999的水仙花数
        for(int i = 100;i < 1000;i++){
            if(Math.pow(i/100,3)+Math.pow((i%100)/10,3)+Math.pow(i%10,3) == i){
                System.out.println(i+"是水仙花数");
            }
        }
    }
}
