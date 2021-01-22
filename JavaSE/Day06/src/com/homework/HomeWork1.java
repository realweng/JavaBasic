package com.homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-9:38
 * @Since:jdk1.8
 * @Description:TODO
 */
    /*
    从键盘输入8个整数存放在一个数组中，然后将奇数和偶数分别存入到两个不同的数组中，
    并按奇数、偶数交替的顺序输出这两个数组中的所有数据
    （先交替输出，如果奇数个数多，则再输出剩下的奇数，如果偶数个数多，则再输出剩下的偶数）。
    （提示与要求：（1）定义一个数组存储从键盘输入的8个整数，先判断这8个整数中奇数和偶数的个数，
    才能定义存储奇数和偶数的数组的长度；（2）把一个大的数组分别存放在奇数和偶数数组中并交替输出的过程定义为方法）。
     */
public class HomeWork1 {
    //扫描仪
    static Scanner sc = new Scanner(System.in);

    /**
     * 判断数组中奇数的个数
     */
    public static int countJi(int num[]) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (num[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断数组中偶数的个数
     */
    public static int countOu(int num[]) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (num[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 存奇数到员工数组中
     *
     * @param num   数组名
     * @param count 传入奇数个数
     * @return 返回奇数数组的对象
     */
    public static int[] storgeJi(int num[], int count) {
        int ji[] = new int[count];

        for (int i = 0, j = 0; i < 8; i++) { //将奇数偶数分数组存储
            if (num[i] % 2 != 0) {
                ji[j] = num[i];
                j++;
            }
        }
        return ji;
    }

    /**
     * 存偶数存储到数组中
     *
     * @param num   数组名
     * @param count 传入奇数个数
     * @return 返回奇数数组的对象
     */
    public static int[] storgeOu(int num[], int count) {
        int ou[] = new int[count];

        for (int i = 0, j = 0; i < 8; i++) { //将奇数偶数分数组存储
            if (num[i] % 2 == 0) {
                ou[j] = num[i];
                j++;
            }
        }
        return ou;
    }

    /**
     * 奇偶数交替输出
     *
     * @param ji 奇数数组
     * @param ou 偶数数组
     */
    public static void printNum(int ji[], int ou[]) {
        int count1 = ji.length, count2 = ou.length;
        if (count1 >= count2) {
            for (int i = 0; i < count2; i++) {
                System.out.print(ji[i] + "\t" + ou[i] + "\t");
            }
            for (int i = count2; i < count1; i++) {
                System.out.print(ji[i] + "\t");
            }
        } else {
            for (int i = 0; i < count1; i++) {
                System.out.print(ji[i] + "\t" + ou[i] + "\t");
            }
            for (int i = count1; i < count2; i++) {
                System.out.print(ou[i] + "\t");
            }
        }
    }

    /**
     * 程序启动
     */
    public static void start() {
        //定义的数组
        int num[] = new int[8];
        System.out.println("请输入8个整数：");
        //统计奇数偶数的个数
        for (int i = 0; i < 8; i++) {
            num[i] = sc.nextInt();
        }
        int count1 = countJi(num);
        int count2 = countOu(num);
        //声两个数组分别用来存放奇数偶数
        int ji[] = new int[count1];
        int ou[] = new int[count2];

        //交替输出奇偶数
        ji = storgeJi(num, count1);
        ou = storgeOu(num, count2);
        printNum(ji, ou);
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        //开始执行程序
        start();
    }
}