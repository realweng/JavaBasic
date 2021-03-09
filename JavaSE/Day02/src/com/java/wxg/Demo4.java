package com.java.wxg;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/17-11:44
 * @Since:jdk1.8
 * @Description:if else
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入考试成绩：");
        double score = input.nextDouble();
        if(score < 60){
            System.out.println("成绩不及格");
        }else
            System.out.println("成绩合格");
        System.out.println("请输入考试科目");
        String km = input.next();
        if(km.equals("Java基础")){
            System.out.println("考对了！");
        }else
            System.out.println("考错了");
    }
}