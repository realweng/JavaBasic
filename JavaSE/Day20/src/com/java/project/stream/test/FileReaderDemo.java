package com.java.project.stream.test;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-10:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        File file = new File("123.txt");
        File file1 = new File("321.txt");
        if (!file.exists()||!file1.exists()) {
            try {
                file.createNewFile();
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (
                    Reader reader = new FileReader(file);
                    Writer writer = new FileWriter(file1);
            ) {
                //一个一个字符读取
//                int result = 0;
//                StringBuffer stringBuffer = new StringBuffer();
//                while ((result = reader.read())!=-1){
//                    System.out.println((char)result);
//                    writer.write(result);
//                }

//                int result = 0;
//                char ch[] = new char[1024];
//                while ((result = reader.read(ch))!=-1){
//                    System.out.println(new String(ch));
//                    writer.write(ch);
//                }

                int result = 0;
                char[] chars = new char[1024];//缓冲区
                while ((result = reader.read(chars))!=-1){
                    System.out.println(new String(chars,0,result));
                    writer.write(new String(chars,0,result));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}