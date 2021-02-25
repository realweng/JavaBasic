package com.java.student;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-19:41
 * @Since:jdk1.8
 * @Description:TODO
 */

import java.io.File;
import java.util.Scanner;

/**
 * 使用IO技术，开发出一个控制台的资源管理器！
 * 要求：从命令行输入一个路径！如果存在,
 * 将该目录下所有的文件和文件夹列举出来，如果不存在则输出不存在该路径。
 */
public class HomeWork2 {
    static Scanner scanner = new Scanner(System.in);

    /**
     * 用来显示文件夹下的文件和文件夹
     * @param file
     */
    public static void showFile(File file){
        File files[] = file.listFiles();
        for (File file1 : files) {
//            if(file1.isDirectory()){
//                showFile(file1);
//            }
            System.out.println(file1.getName());
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入一个文件路径");
        String path = scanner.nextLine();
        File file = new File(path);
        if(file.exists()){
            if(file.isDirectory()){
                showFile(file);
            }else {
                System.out.println("这是一个文件");
                System.out.println("文件名："+file.getName());
            }
        }else {
            System.out.println("不存在该路径");
        }
    }
}