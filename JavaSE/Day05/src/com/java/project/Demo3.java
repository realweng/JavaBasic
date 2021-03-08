package com.java.project;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-17:33
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo3 {
    public static void main(String[] args) {
        //输入班级个数，及其对应班级各个学生对应的分数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级个数：");
        int m = sc.nextInt();
        double allNums[][] = new double[m][];
        double max[] = new double[m]; //每个班级的最高成绩
        double min[] = new double[m]; //每个班级最低成绩
        double sum[] = new double[m]; //每个班的成绩总和
        double avg[] = new double[m]; //每个班的平均成绩
        int n[] = new int[m];
        for (int i =0;i < m;i++){
            System.out.println("请输入第"+(i+1)+"个班级的人数");
            n[i] = sc.nextInt();
            //通过人数 创建一维数组的长度
            max[i] = -1;
            min[i] = 999999999;
            sum[i] = 0;
            double[] numbers = new double[n[i]];
            for (int j = 0;j < n[i];j++){
                System.out.println("请输入第"+(i+1)+"个班级的第"+(j+1)+"个学生的成绩：");
                numbers[j] = sc.nextDouble();
                sum[i] += numbers[j];          //计算总成绩
                if(max[i] < numbers[j]){       //判断分数最高的
                    max[i] = numbers[j];
                }
                if(min[i] > numbers[j]){       //判断分数最低的
                    min [i] = numbers[j];
                }
            }
            allNums[i] = numbers;              //将成绩的一维数组存到二维数组中
            avg[i]=sum[i]/n[i];                   //每个班的平均成绩
        }

        for (double[] allNum : allNums) {
            for (double num : allNum) {
                System.out.print(num+"\t");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            System.out.println("第"+(i+1)+"个班级有"+n[i]+"个学生，"+"其中最高分为:"+max[i]+"\t最低分为:"+min[i]+"\t平均分为："+avg[i]);
        }
        double maxAvg = avg[0];                //假设maxAvg为各个班级比较得出的最大平均数，平均数高班级总体考得就好
        int index = 0;                         //通过索引记录哪个班的平均分最高，得出哪个班总体成绩好的结论
        for (int i = 0; i < m; i++) {
            if(maxAvg < avg[i]){
                maxAvg = avg[i];
                index = i;
            }
        }
        System.out.println("其中" + (index + 1) + "班的总体表现更好");

    }
}