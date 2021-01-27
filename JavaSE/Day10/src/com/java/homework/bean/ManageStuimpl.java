package com.java.homework.bean;

import com.java.homework.inter.ManageStudent;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:35
 * @Since:jdk1.8
 * @Description:作业3 学生成绩管理的实现类
 */
public class ManageStuimpl implements ManageStudent {
    private Stu[] stu;
    private Scanner sc;
    /**
     * 构造器 数据初始化
     */
    public ManageStuimpl() {
        sc = new Scanner(System.in);
        stu = new Stu[5];
        stu[0] = new Stu("张三",90,78,77);
        stu[1] = new Stu("李四",71,98,97);
        stu[2] = new Stu("王五",84,81,67);
        stu[3] = new Stu("张杰",72,74,80);
        stu[4] = new Stu("赵六",65,99,78);
    }

    /**
     * 展示某一个学生的成绩
     * @param name 学生姓名当做参数
     */
    @Override
    public void showGrade(String name) {
        boolean isFlag = false;
        for (int i = 0; i < stu.length; i++) {
            if(stu[i].getName().equals(name)){ //找到对应的学生
                System.out.println(stu[i].getName()+"同学的各科成绩如下：");
                System.out.println("语文："+stu[i].getChinese()+"\t"+"数学："+
                        stu[i].getMath()+"\t"+"英语："+stu[i].getEnglish());
                isFlag = true;
                return;
            }
        }
        if(!isFlag){
            System.out.println("没有找到该学生！");
            return;
        }
    }

    /**
     * 计算几个的科目数及其总分
     * @param name
     */
    @Override
    public void calGrade(String name) {
        boolean isFlag = false;
        int count = 0; //及格科目的数目
        double sum = 0;   //各科成绩的总和
        for (int i = 0; i < stu.length; i++) {
            if(stu[i].getName().equals(name)){ //找到对应的学生
                if(stu[i].getChinese() >= 60){
                    count++;
                }
                if(stu[i].getMath() >= 60){
                    count++;
                }
                if(stu[i].getEnglish() >= 60){
                    count++;
                }
                sum = stu[i].getChinese()+stu[i].getMath()+stu[i].getEnglish();
                System.out.println(name+"同学及格的科目数为："+count+"\t"+"总成绩为："+sum);
                isFlag = true;
                return;
            }
        }
        if(!isFlag){
            System.out.println("没有找到该学生！");
            return;
        }
    }

    /**
     * 显示所有学生的成绩
     */
    @Override
    public void showAll() {
        System.out.println("姓名"+"\t"+"语文"+"\t"+"数学"+"\t"+"英语");
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i].getName()+"同学"+"\t"+stu[i].getChinese()+
                    "\t"+stu[i].getMath()+"\t"+stu[i].getEnglish());
        }
    }
}