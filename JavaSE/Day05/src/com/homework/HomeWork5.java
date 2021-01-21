package com.homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-18:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork5 {
    public static void main(String[] args) {
        /*
        实现点外卖操作：
        进入点餐系统，依次录入你要点的外卖名称。显示对应的价格。点完一个外卖之后，询问是否继续？直到退出点餐。然后进行结算！
        提示：需定义一个数组，存储了外卖名称和价格。然后根据名称查找价格！最后进行结算！使用一维数组或二维数组都可以
         */

//        String menu[][] = {
//                {"A","15"},
//                {"B","12.5"},
//                {"C","13"},
//                {"D","17.9"},
//                {"E","19"},
//        };
//        for (int i = 0; i < menu.length; i++) {
//            System.out.println("欢迎进入点餐系统,请按提示操作");
//            for (int j = 0; j < menu.length; j++) {
//                System.out.println();
//                switch (menu[][])
//            }
//        }
        Scanner sc = new Scanner(System.in);
        String menu[] = {"A","B","C","D","E"};
        double price[] = {15,12.5,13,17.9,19};
        System.out.println("欢迎进入点餐系统,请按提示操作");
        double sum = 0;
        while (true){
            System.out.println("\t请输入你需要选择的套餐：\t");
            System.out.println("\t1.A套餐*********15.0元\t");
            System.out.println("\t2.B套餐*********12.5元\t");
            System.out.println("\t3.C套餐*********13.0元\t");
            System.out.println("\t4.D套餐*********17.9元\t");
            System.out.println("\t5.E套餐*********19.0元\t");
            int i = sc.nextInt();
            switch (menu[i-1]){
                case "A":
                    System.out.println("您选择了A套餐！");
                    sum+=15;
                    break;
                case "B":
                    System.out.println("您选择了B套餐！");
                    sum+=12.5;
                    break;
                case "C":
                    System.out.println("您选择了C套餐！");
                    sum+=13.0;
                    break;
                case "D":
                    System.out.println("您选择了D套餐！");
                    sum+=17.9;
                    break;
                case "E":
                    System.out.println("您选择了E套餐！");
                    sum+=19.0;
                    break;
                default:
                    break;
            }
            System.out.println("请问您还继续点餐吗？y/n");
            String str = sc.next();
            if(str.equals("n")){
                break;
            }
        }
        System.out.println("最终的价格为："+sum+"元！");

    }
}