package com.java.file;

import java.io.*;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-17:48
 * @Since:jdk1.8
 * @Description:输出流
 */
public class FileOutputStreamDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * 将内容输入到文件中
         */
        File file = new File("E:\\123.txt");
        //创建输出流
        OutputStream outputStream = null;
        try {
            //创建输出流对象
            outputStream = new FileOutputStream(file);
            //通过流将控制台内容写入到文件中
            outputStream.write(49);
            outputStream.write("ssss".getBytes());
            System.out.println("请输入要写入文件的内容：");
            String s = scanner.nextLine();
            outputStream.write(s.getBytes());
            outputStream.write(s.getBytes(), 0, s.getBytes().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}