package com.java.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/31-14:37
 * @Since:jdk1.8
 * @Description:异常处理方式2
 */
public class ExceptionTest2 {

    public void method() throws FileNotFoundException, IOException{
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        ExceptionTest2 t2 = new ExceptionTest2();
        t2.method();
    }
}