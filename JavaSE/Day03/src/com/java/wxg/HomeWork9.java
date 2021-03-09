package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-19:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork9 {
    public static void main(String[] args) {
        /*
        完成猜数字游戏：
        随机生成一个1-100之间的数字，进行猜数字游戏。
        如果用户输入的数字较小，则提醒：你猜的大小了！
        如果用户输入的数字较大，则提醒：你猜的太大了。
        直到用户猜对了为止。
        如果用户一次就猜对了，输出：你真是太聪明了，一次就猜对了！
        如果用户猜的次数小于3次，输出：你还是比较聪明的哦！
        如果用户猜的次数大于6次，则输出：你真是太笨了！
         */
        Scanner sc = new Scanner(System.in);
        int num = (int) (Math.random()*100+1);
        int n = 0,count =0;
        System.out.println("随机生成的数字是"+num);
        do{
            System.out.println("请输入你猜的数：");
            n = sc.nextInt();
            if(n > num){  //如果用户输入的数字较大
                count++;
                System.out.println("你猜的太大了");
            }
            else if(n < num){  //如果用户输入的数字较小
                count++;
                System.out.println("你猜的太小了");
            }
            else
                break;

        }while (n != num);
        if(count < 3 && count != 0){
            System.out.println("你还是比较聪明的哦！");
        }else if(count > 6){
            System.out.println("你真是太笨了！");
        }else if(count == 0)
            System.out.println("你真是太聪明了，一次就猜对了！");
         else
            System.out.println("猜对了！");
    }
}