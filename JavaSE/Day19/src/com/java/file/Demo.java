package com.java.file;

import java.io.*;
import java.io.FileInputStream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-18:44
 * @Since:jdk1.8
 * @Description:将一个文件里面的内容通过流写入到另一个文件中
 */
public class Demo {
    public static void readAndWrite(File readFile, File writeFile) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            int result = 0;
            inputStream = new FileInputStream(readFile);
            //字节缓冲区
            byte bytes[] = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            //通过输入流读取文件内容
            while ((result = inputStream.read(bytes,0,bytes.length))!=-1){
                stringBuffer.append(new String(bytes));
            }
            //通过输出流写入内容到文件
            outputStream = new FileOutputStream(writeFile);
            outputStream.write(stringBuffer.toString().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        File readFile = new File("E:\\123.txt");
        File writeFile = new File("E:\\321.txt");
        readAndWrite(readFile,writeFile);
    }
}