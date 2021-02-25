package com.java.stream.test;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-11:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BufferedDemo {
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
        }else {
            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
                    ){
                String result = null;
                while ((result = bufferedReader.readLine())!=null){
                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}