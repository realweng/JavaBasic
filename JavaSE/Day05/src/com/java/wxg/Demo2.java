package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-16:44
 * @Since:jdk1.8
 * @Description:二维数组
 */
public class Demo2 {
    public static void main(String[] args) {
        int nums[][] = new int[3][3];

        nums[0][0] = 10;
        nums[0][1] = 20;
        nums[0][2] = 30;

        nums[1][0] = 40;
        nums[1][1] = 50;
        nums[1][2] = 60;

        nums[2][0] = 70;
        nums[2][1] = 80;
        nums[2][2] = 90;

        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }


    }
}