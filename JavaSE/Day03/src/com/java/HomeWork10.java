package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-19:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork10 {
    public static void main(String[] args) {
        /*
        假设一个简单的ATM机的取款过程是这样的：
        首先提示用户输入密码（password），
        最多只能输入三次，超过3次则提示用户“密码错误，请取卡”结束交易。如果用户密码正确，
        再提示用户输入取款金额（amount），
        ATM机只能输出100元的纸币，一次取钱数要求最低100元，最高1000元。
        若用户输入的金额符合上述要求，则打印输出用户取得钱数，
        最后提示用户“交易完成，请取卡”，否则提示用户重新输入金额。
        假设用户密码是111111，请编程实现。
         */
        Scanner sc = new Scanner(System.in);
        String pwd = null;
        int cnt = 0;
        System.out.println("请输入密码：");
        do{
            pwd = sc.next();
            if(pwd.equals("111111")){
                while (true){
                    System.out.println("请输入你的取款金额：");
                    int amount = sc.nextInt();
                    if(amount < 100 || amount > 1000){
                        System.out.println("ATM机只能输出100元的纸币，一次取钱数要求最低100元，最高1000元");
                        continue; //金额没有按照规定，跳出当前循环重新输入金额以进行判断
                    }else{
                        System.out.println("成功取款"+amount+"元");
                        System.out.println("交易完成，请取卡");
                        break; //取款成功，推出判断交易金额的循环
                    }
                }
                break; //取款成功，退出外循环
            }
            System.out.println("密码输入错误请重新输入");
            cnt++;
            if(cnt == 3){
                System.out.println("操作超过上限，密码错误，请取卡");
                break;
            }
        }while(true);
    }
}