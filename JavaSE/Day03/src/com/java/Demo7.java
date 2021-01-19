package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-16:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo7 {
    public static void main(String[] args) {
        //正方形
        for(int i = 1;i <= 10;i++){
            for (int j = 1;j <= 10;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        //三角形
        for(int i = 1;i <= 10;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        //9*9乘法表
        for(int i = 1;i <= 10;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(j+" * "+i+" =  "+(i*j)+"\t");
            }
            System.out.println();
        }

        //倒三角形
        for(int i = 1;i <= 10;i++){
            for (int j = 10;j >= i;j--){
                System.out.print(" * ");
            }
            System.out.println();
        }

        //等腰三角形
        /*
                   *
                  * *
                 * * *
                * * * *
         */
        for(int i = 1;i <= 9;i++){

            for (int j = 9;j > i;j--){
                System.out.print(" ");
            }
            for (int k = 1;k < i;k++){
                System.out.print(" * ");
            }
            System.out.println();
        }

    }
}