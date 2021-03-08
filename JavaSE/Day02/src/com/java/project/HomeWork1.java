package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-17:01
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork1 {
    public static void main(String[] args) {
        /*
        需求说明：录入会员信息（会员号、会员生日、会员积分）并显示录入信息
        升级功能：
        判断录入是否合法（会员号必为4位整数），
        录入合法，显示录入的信息；
        不合法，显示“录入失败”
         */
        Scanner sc = new Scanner(System.in);
        int vipNum,score;
        String birthday;
        System.out.println("依次输入会员号、会员生日、会员积分");
        vipNum = sc.nextInt();
        birthday = sc.next();
        score = sc.nextInt();
        if(vipNum > 10000 || vipNum < 1000){
            System.out.println("会员号必为4位整数,录入失败");
        }else
            System.out.println("会员号:"+vipNum+"会员生日:"+birthday+"会员积分"+score);
    }
}