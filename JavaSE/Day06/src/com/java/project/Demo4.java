package com.java.project;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-14:22
 * @Since:jdk1.8
 * @Description:将多次重复的语句改成函数
 */
public class Demo4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //数组增删改查

        String names[] = {"a","b","c"};

        //添加
        while (true){
            int len = names.length;
            names = Arrays.copyOf(names,len+1);
            System.out.println("输入要添加的姓名：");
            names[len] = sc.next();
            System.out.println("请输入是否继续添加y/n ?");
            String str = sc.next();
            if(str.equals("n")){
                break;
            }
        }
        System.out.println("添加后的结果："+Arrays.toString(names));

        //删除
        while (true){
            System.out.println("请输入你要删除的姓名：");
            String deleteName = sc.next();
            int deleteIndex = -1;
            for (int i = 0; i < names.length; i++) {
                if(names[i].equals(deleteName)){
                    deleteIndex = i;
                    break;
                }
            }
            if(deleteIndex == -1){
                System.out.println("没有找到要删除的姓名!");
                continue;
            }else {
                //执行删除操作,deleteIndex之后的元素往前移把deleteIndex索引位置覆盖
                for (int i = deleteIndex; i < names.length-1; i++) {
                    names[i] = names[i+1];
                }
            }
            names = Arrays.copyOf(names,names.length-1); //删除最后一位
            System.out.println("请输入是否继续删除y/n ?");
            String str = sc.next();
            if(str.equals("n")){
                break;
            }
        }
        System.out.println("删除后的结果："+Arrays.toString(names));

        //修改
        System.out.println("请输入你要修改的姓名：");
        String reName = sc.next();
        int renameIndex = -1;
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(reName)){
                renameIndex = i;
                break;
            }
        }
        if(renameIndex == -1){
            System.out.println("没有找到想要修改的姓名!");
        }else {
            //执行修改操作
            System.out.println("请输入你要修改后的姓名：");
            names[renameIndex] = sc.next();
        }

        System.out.println("修改后的结果："+ Arrays.toString(names));


    }
    //查找
    public static boolean find(String []names){
        System.out.println("请输入你要查找的姓名：");
        String findName = sc.next();
        int findIndex = -1;
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(findName)){
                findIndex = i;
                break;
            }
        }
        if(findIndex == -1){
            System.out.println("没有找到该姓名!");
            return false;
        }
        return true;
    }

    //修改

}