package com.java.project.homework;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-19:53
 * @Since:jdk1.8
 * @Description:从控制台输入一些字符串，并将该类信息保存到日志文件”log.txt”中去。
 */
public class HomeWork3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("E:\\log.txt");
        if(!file.exists()){//如果文件不存在就创建
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("请输入：");
        String s = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(s);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(stringBuffer.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}