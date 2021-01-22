package com.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-16:18
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo5 {
    static Scanner sc = new Scanner(System.in);
    static String names[] = {"zs","ls","ww","gx"};
    static double moneys[] = {1900,2000,2500,3500};

    /**
     * 增加员工信息
     */
    public static void add(){
        names = Arrays.copyOf(names,names.length+1);
        moneys = Arrays.copyOf(moneys,moneys.length+1);
        System.out.println("请输入你要添加的姓名：");
        names[names.length - 1] = sc.next();
        System.out.println("请输入你要添加的工资：");
        moneys[moneys.length-1] = sc.nextDouble();
    }

    /**
     *删除员工信息
     */
    public static void delete(){
        System.out.println("请输入要删除的姓名：");
        String name = sc.next();
        //boolean flag = false;
        int count = findIndexByName(name);  //通过name找到索引值
        if(count!=-1){
            System.out.println("找到了，正在执行删除操作");
            for (int i = count;i < names.length-1;i++){
                names[i] = names[i+1];
                moneys[i] = moneys[i+1];
            }
            names = Arrays.copyOf(names,names.length-1);
            moneys = Arrays.copyOf(moneys,moneys.length-1);
        }else
            System.out.println("没有查询到此人，请按提示重新操作！");
    }

    /**
     *修改员工信息
     */
    public static void update(){
        System.out.println("请输入要修改的姓名：");
        String name = sc.next();
        //boolean flag = false;
        int count = findIndexByName(name);  //通过name找到索引值
        if(count!=-1){
            System.out.println("找到了请输入要修改员工的姓名及其工资：");
            names[count] = sc.next();
            moneys[count] = sc.nextDouble();
        }else
            System.out.println("没有查询到此人，请按提示重新操作！");
    }

    /**
     * 通过name找到索引值
     * @param name 通过name找到索引值
     * @return 返回索引
     */
    public static int findIndexByName(String name) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if(name.equals(names[i])){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     *查询员工信息
     */
    public static boolean findAll(){
        System.out.println("请输入要查询的姓名：");
        String name = sc.next();
        boolean flag = false;
        for (int i = 0; i < names.length; i++) {
            if(name.equals(names[i])){
                flag = true;
                break;
            }
        }
        if(flag==true){
            System.out.println("找到了");
        }else
            System.out.println("没有查询到此人，请按提示重新操作！");
        return flag;
    }

    public static void start(){
        while (true){
            boolean endFlag = false;
            System.out.println("当前员工信息：");
            System.out.println("姓名："+Arrays.toString(names));
            System.out.println("工资："+Arrays.toString(moneys));
            System.out.println("请输入你要进行操作的序号");
            System.out.println("1、*****增加员工信息*****");
            System.out.println("2、*****删除员工信息*****");
            System.out.println("3、*****修改员工信息*****");
            System.out.println("4、*****查询员工信息*****");
            System.out.println("5、******退出程序*****");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    findAll();
                    break;
                case 5:
                    System.out.println("程序结束，退出系统");
                    endFlag = true;
                    break;
                default:
                    break;
            }
            if(endFlag == true){
                break;
            }
        }
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        start();
    }
}