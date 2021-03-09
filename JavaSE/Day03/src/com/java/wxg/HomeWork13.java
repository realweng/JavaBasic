package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-20:23
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork13 {
    public static void main(String[] args) {
        /*
        购物管理系统生日问候
        请输入今天的日期（月/日<用两位数表示：）： 05/29
        请输入客户生日：08/09
        然后判断是否今天生日
        是否继续（y/n)
        如果是y就重复以上步骤，否则退出程序
        字符串判断相等： "05/29".equals(birthday);
         */
        Scanner sc = new Scanner(System.in);

        String y = "y";
         while (y.equals("y")){
             System.out.println("请输入今天的日期（月/日<用两位数表示：）：");
             String today = sc.next();
             System.out.println("请输入客户的生日：");
             String birthday = sc.next();
             if(birthday.equals(today)){
                 System.out.println("客户今天生日！");
             }else
                 System.out.println("客户不是今天生日");
             System.out.println("请问是否继续操作：y/n ?");
             y = sc.next();
         }
    }
}