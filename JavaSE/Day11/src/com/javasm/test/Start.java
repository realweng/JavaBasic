package com.javasm.test;

import com.javasm.bean.Number;
import com.javasm.bean.Student;

import java.util.Scanner;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/1/28-10:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {

    //启动程序的时候准备初始化的数据
    //学生的数组
    private Student[] students;
    private Scanner scanner;

    public Start() {
        students = new Student[3];
        scanner = new Scanner(System.in);
        init();
    }

    /**
     * 数据初始化
     */
    public void init() {
        //第一个人
        Number[] numbers = new Number[2];
        numbers[0] = new Number("Java基础", 80);
        numbers[1] = new Number("Java高级", 90);
        students[0] = new Student("tom", numbers);
        //第二个人
        Number[] numbers1 = new Number[2];
        numbers1[0] = new Number("Web基础", 77);
        numbers1[1] = new Number("Java高级", 88);
        students[1] = new Student("cat", numbers1);
        //第一个人
        Number[] numbers2 = new Number[2];
        numbers2[0] = new Number("Java基础", 66);
        numbers2[1] = new Number("Web基础", 95);
        students[2] = new Student("lili", numbers2);
    }

    /**
     * 启动菜单
     */
    public void startMenu(){
        StudentTest studentTest = new StudentTest();
        System.out.println("1、根据名称查找  2、查看成绩  3、添加学生");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                studentTest.findNumber(students,scanner);
                break;
            case 3:
                studentTest.addStudent(students,scanner);
        }
    }

    /**
     * 启动程序
     * @param args
     */
    public static void main(String[] args) {
        //直接调用启动的菜单
        new Start().startMenu();
    }
}
