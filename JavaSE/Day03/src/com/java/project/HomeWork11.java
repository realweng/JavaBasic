package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork11 {
    public static void main(String[] args) {
        //输出 9 * 9 乘法口诀表
        for(int i = 1;i <= 9;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(j+" * "+i+" = "+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}