package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-10:01
 * @Since:jdk1.8
 * @Description:while循环练习
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 3){
            System.out.println("你好"+i);
            i++;
        }

        int n = 1;
        int sum =0;
        while (n <= 100){
            sum += n;
            n++;
        }
        System.out.println(sum);

        int j = 1;
        int cnt = 0;
        while (j <= 100){
            if(j % 2 == 0){
                cnt++;
            }
            j++;
        }
        System.out.println("100内的偶数个数为："+cnt);
    }
}