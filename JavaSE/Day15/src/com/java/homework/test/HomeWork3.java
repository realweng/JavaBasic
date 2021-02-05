package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-19:05
 * @Since:jdk1.8
 * @Description:作业3
 */

import com.java.homework.bean.Student;
import com.java.homework.util.Base64Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 实现“学生管理系统”：
 * 添加学生：依次输入学生的：学号、姓名、年龄、性别和联系方式。
 * 存入到集合中。要求学号不允许重复，并且要对联系方式进行加密操作。
 * 显示所有的学生信息。
 * 统计人数：分别统计总人数、男生的占比和女生的占比分别是？
 * 移除学生：移除所有年龄小于18岁的学生信息。
 */
public class HomeWork3 {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * 判断学号是否重复
     * @return false表示未重复
     */
    public boolean isReiterate(String str){
        if(students.size()==0){
            return false;//如果集合是空的直接返回false表示没有重复
        }else {
            for (Student student : students) {
                if(student.getId().equals(str)){
                    return true; //如果找到重复的id就返回true
                }
            }
        }
        return false;
    }

    /**
     * 添加学生
     */
    public void addStu(){
        System.out.println("请输入学号：");
        String id = scanner.next();
        if(isReiterate(id)){
            System.out.println("学号已经被注册，请重新输入！");
            return;
        }
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入性别：");
        String gender = scanner.next();
        System.out.println("请输入电话号码：");
        String phone = scanner.next();
        System.out.println("加密联系方式中....");
        phone = Base64Util.encryption(phone);
        Student student = new Student(id,name,Integer.valueOf(age),gender,phone);
        students.add(student);
        System.out.println("学生添加成功！");
    }

    /**
     * 统计学生
     */
    public void statistic(){
        if(students.size()==0){
            System.out.println("当前还未添加学生！");
            return;
        }
        int count1 = 0,count2 = 0,count3 = 0;//分别记录男生女生和性别未设定人的个数
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getGender().equals("男")){
                count1++;
            }else if(students.get(i).getGender().equals("女")){
                count2++;
            }else
                count3++;
        }
        System.out.println("当前班级的学生总数为："+students.size());
        System.out.println("男生总数为："+count1+"\t占班级总数的："+(double)(100*count1/students.size())+"%");
        System.out.println("女生总数为："+count2+"\t占班级总数的："+(double)(100*count2/students.size())+"%");
    }

    /**
     * 移除所有小于18岁的学生
     */
    public void removeStu(){
        if(students.size()==0){
            System.out.println("当前班级还没有添加学生！");
            return;
        }
        System.out.println("正在移除年龄小于18岁的学生！");
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getAge()<18){
                students.remove(students.get(i));
                i--;
            }
        }
        System.out.println("移除操作结束");
    }
    /**
     * 显示学生信息
     */
    public void show(){
        System.out.println("-----------------------------------------------------");
        System.out.println("学号\t姓名\t年龄\t性别\t联系方式");
        System.out.println("-----------------------------------------------------");
        students.forEach(student -> {
            System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t"
                    +student.getGender()+"\t"+student.getPhone());
            System.out.println("-----------------------------------------------------");
        });
    }

    /**
     * 开始执行程序
     */
    public void start(){
        menu();
    }

    /**
     * 菜单
     */
    public void menu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("1.添加 2.显示 3.移除小于18的学生 4.统计 5.退出");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    System.out.println("----->添加");
                    addStu();
                    break;
                case 2:
                    System.out.println("----->显示");
                    show();
                    break;
                case 3:
                    System.out.println("----->移除");
                    removeStu();
                    break;
                case 4:
                    System.out.println("----->统计");
                    statistic();
                    break;
                case 5:
                    System.out.println("----->退出");
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        new HomeWork3().start();
    }
}