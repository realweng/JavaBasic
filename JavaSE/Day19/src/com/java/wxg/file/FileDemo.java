package com.java.wxg.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-16:11
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FileDemo {
    public static void main(String[] args) {
        //在相对路径创建一个a.txt的文件
        File file1 = new File("a.txt");
        //在绝对路径创建a.txt文件
        File file2 = new File("E:\\aaa\\a.txt");
        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件名称："+file1);
            System.out.println("文件名称："+file1.getName());   //文件    文件夹  file：目录  getName：文件名称
            System.out.println("file1的绝对路径："+file1.getAbsolutePath());
            System.out.println("文件的长度："+file1.length());  //返回的是字节数
        }
        if(!file2.exists()){
                //创建文件夹
                boolean b = file2.mkdirs();
                System.out.println(b);
               // file2.createNewFile();
        }else{
            //获取文件夹下的子目录
            File[] files = file2.listFiles();
            for (File file : files) {
                System.out.println(file);
            }
        }
    }
}