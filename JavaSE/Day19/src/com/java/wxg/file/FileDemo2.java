package com.java.wxg.file;

import java.io.File;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-16:11
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FileDemo2 {
    /**
     * 显示目录下的文件
     *
     * @param file1
     */
    public static void showFile(File file1) {
        File[] files = file1.listFiles();//存储目录下的文件
        for (File file : files) {
            //判断是否是目录
            if (file.isDirectory()) {
                //递归
                showFile(file);
            }
            //输出以.exe结尾的文件
            if (file.isFile()) {
                String name = file.getName();
                //以.exe结尾
                if (name.endsWith(".exe")) {
                    System.out.println(name);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\4031\\软件工具");
        showFile(file);
    }
}