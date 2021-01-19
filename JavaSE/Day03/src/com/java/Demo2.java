package com.java;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-10:13
 * @Since:jdk1.8
 * @Description:do while
 */
public class Demo2 {
    public static void main(String[] args) {
        int n = 1;
        do{
            if(n % 5 == 0){
                System.out.println(n+"是50内被5整除的数");
            }
            n++;
        }while (n <= 50);

        int num = 5;
        while (n<5){
            System.out.println("I'm king");
            //num++;
        }

        do{
            System.out.println("I'm king");
            num++;
        }while (num < 5);

        Scanner sc = new Scanner(System.in);
        String say = null;
//        do{
//            System.out.println("男生说：我喜欢你你喜欢我吗？");
//            say = sc.next();
//        }while (!say.equals("喜欢"));
//
//        //会员号非4位数重新输入
//        System.out.println("请输入会员号");
//        int vipNum = sc.nextInt();
//
//        do {
//                if(vipNum<1000 || vipNum >9999){
//                    System.out.println("会员号格式输入错误请重新输入：");
//                    vipNum = sc.nextInt();
//                }else
//                    break;
//        }while(true);

//        while(vipNum<1000 || vipNum >9999){
//            System.out.println("会员号格式输入错误请重新输入：");
//            vipNum = sc.nextInt();
//        }

        //登录系统，错误三次就退出
        int cnt = 0;
        String qq = null,pwd = null;
//        do{
//            System.out.println("请输入qq号");
//            qq = sc.next();
//            if(!qq.equals("123456")){
//                System.out.println("qq号码输入错误请重新输入");
//                    continue;
//            }else{
//                System.out.println("请输入密码：");
//                pwd = sc.next();
//                if(!(pwd.equals("123456") && (qq.equals("123456")))){
//                    cnt++;
//                    if(cnt > 3){
//                        System.out.println("用户名密码输入次数超过上限，程序退出");
//                    }
//                    System.out.println("密码输入错误请重新输入用户名密码：");
//                }
//                else {
//                    System.out.println("用户名密码正确，登录成功！");
//                    break;
//                }
//            }
//        }while (cnt < 3);
        while(cnt < 3){
            System.out.println("请输入用户名");
            qq = sc.next();
            if(qq.equals("123456")){
                System.out.println("请输入密码：");
                pwd = sc.next();
                if(qq.equals("123456")&&pwd.equals("123456")){
                    System.out.println("用户名密码输入正确！");
                    cnt = 4;
                }else {
                    cnt++;
                    System.out.println("用户名密码输入错误，你还有"+(3 - cnt)+"次输入机会！");
                }
            }else
                System.out.println("用户名输入错误请重新输入！");
        }

    }
}