package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork17 {
    public static void main(String[] args) {
        //打印菱形
        System.out.println("*********菱形*********");
        for(int i = 1; i <= 6; i++){
            for(int j = 5; j >= i;j--){
                System.out.print(" ");
            }//控制空白
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }//控制*
            System.out.println();  //换行
        }
        for(int i = 1; i <= 6; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for(int j = 5; j >= i;j--){
                System.out.print("* ");
            }
            System.out.println();  //换行
        }
    }
}