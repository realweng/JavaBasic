package com.java.wxg.file;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-19:08
 * @Since:jdk1.8
 * @Description:高效流
 */
public class Demo2 {
    /**
     * @param readFile
     * @param writeFile
     */
    public static void readAndWrite(File readFile, File writeFile) {
        //输入流和输出流
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(readFile));
            outputStream = new BufferedOutputStream(new FileOutputStream(writeFile));

            //输入/读取
            StringBuffer stringBuffer = new StringBuffer();
            //缓冲区
//            byte[] bytes = new byte[1024];
            int result = 0;
            while ((result = inputStream.read()) != -1) {
                stringBuffer.append(result);
            }

            System.out.println(stringBuffer);

            //输出/写入
            outputStream.write(stringBuffer.toString().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        File readFile = new File("E:\\123.txt");
        File writeFile = new File("E:\\321.txt");

        readAndWrite(readFile, writeFile);
    }
}