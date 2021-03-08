package com.java.project.student;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-19:12
 * @Since:jdk1.8
 * @Description:使用IO技术，创建一个目录，然后复制一个文件到该目录
 */
public class HomeWork1 {
    public static void main(String[] args) {
        String path = "E:\\Test";
        File file = new File(path);//需要创建的目录
        if (!file.exists()) {//目录不存在的情况
            file.mkdir();//创建文件夹
            String fileName = "1.txt";
            File file1 = new File("E:\\" + fileName);//需要被复制的文件
            if (file.isDirectory()) {
                if (!file1.exists()) { //如果不存在就创建一个1.txt
                    OutputStream outputStream = null;
                    try {
                        file1.createNewFile();
                        outputStream = new FileOutputStream(file1);
                        outputStream.write("内容".getBytes());//现在E:\1.txt里面的内容就是"内容"
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                       if(outputStream!=null){
                           try {
                               outputStream.close();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                    }
                }
                //将1.txt复制到：就是将E:\1.txt文件内容写入到新建目录中的1.txt
                File file2 = new File(path + "\\" + fileName);//复制的新文件
                if (!file2.exists()) {//文件不存在就创建
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //通过输入输出流将源文件的内容复制到新文件中 file1->file2
                InputStream inputStream = null;
                OutputStream outputStream = null;
                try {
                    //读取file1的内容
                    inputStream = new FileInputStream(file1);
                    int result = 0;
                    //创建缓冲区
                    byte bytes[] = new byte[1024];
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((result = inputStream.read(bytes, 0, bytes.length)) != -1) {
                        stringBuffer.append(new String(bytes));
                    }
                    //将内容写入file2中
                    outputStream = new FileOutputStream(file2);
                    outputStream.write(stringBuffer.toString().getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭流
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}