package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-17:40
 * @Since:jdk1.8
 * @Description:作业1
 */

import com.java.wxg.homework.demo.Stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个方法，来录入学生的成绩。输入人数，然后根据人数来录入对应的成绩，并将成绩存入到集合中。
 * 显示所有人的成绩。
 * 然后计算出学生的总成绩、平均分、最高分和最低分。
 * 然后根据成绩进行从高到低排序。
 */
public class HomeWork1 {
   private List<Stu> stuList = new ArrayList<>(10);
   private Scanner scanner = new Scanner(System.in);

    /**
     * 根据输入的人数来输入成绩并存入集合中
     */
   public void input(){
       System.out.println("请输入学生数：");
       int num = scanner.nextInt();
       for (int i = 0; i < num; i++) {
           System.out.println("请输入第"+(i+1)+"个学生的成绩：");
           int grade = scanner.nextInt();
           int id = i+1;
           Stu stu = new Stu(id,grade);
           stuList.add(stu);
       }
       System.out.println("学生成绩录入完成！");
   }

    /**
     * 显示所有人的成绩
     */
   public void show(){
       System.out.println("------------------------------");
       System.out.println("编号\t成绩");
       System.out.println("------------------------------");
       stuList.forEach(stu->{
           System.out.println(stu.getId()+"\t"+stu.getGrade());
           System.out.println("------------------------------");
       });
   }

    /**
     * 计算出学生的总成绩、平均分、最高分和最低分。
     */
   public void cal(){
       double max = 0,min = 99999;
       double avg = 0,sum = 0;
       double grade = 0;
       for (int i = 0; i < stuList.size(); i++) {
           grade = stuList.get(i).getGrade();
           sum += grade;
            if(max < grade){
                max = grade;
            }
            if(min > grade){
                min = grade;
            }
       }
       avg = sum/stuList.size();
       System.out.println("总成绩："+sum+"\t平均分："+avg+"\t最高分："+max+"\t最低分："+min);
   }

    /**
     * 成绩冒泡排序并且输出排序后的结果
     */
   public void sort(){
       for (int i = 0; i < stuList.size()-1; i++) {
           for (int j = 0; j < stuList.size() - i - 1; j++) {
               if(stuList.get(j).getGrade() < stuList.get(j+1).getGrade()){
                   //实现成绩和对应ID的交换
                   double temp = stuList.get(j).getGrade();
                   int tempIndex = stuList.get(j).getId();
                   stuList.get(j).setGrade(stuList.get(j+1).getGrade());
                   stuList.get(j).setId(stuList.get(j+1).getId());
                   stuList.get(j+1).setGrade(temp);
                   stuList.get(j+1).setId(tempIndex);
               }
           }
       }
       show();
   }

    /**
     * 开始执行程序
     */
   public void start(){
       input();
       show();
       cal();
       sort();
   }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        new HomeWork1().start();
    }
}