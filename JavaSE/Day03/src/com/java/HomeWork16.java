package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:26
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork16 {
    public static void main(String[] args) {
        //打印等腰三角形
        System.out.println("*********等腰三角形*********");
        for(int i = 1; i <= 5; i++){
            for(int j = 4; j >= i;j--){
                System.out.print(" ");
            }//控制空白
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }//控制*
            System.out.println();  //换行
        }
    }
}