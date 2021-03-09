package com.java.wxg.stream.test;

import com.java.wxg.stream.bean.User;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-15:12
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ObjectDemo2 {
    public static void main(String[] args) {
        File file = new File("user.txt");
        ObjectInputStream objectInputStream = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                while (true){
                    User user = (User) objectInputStream.readObject();
                    System.out.println(user.getId()+"\t"+user.getName());
                }
            } catch (EOFException e) {
                System.out.println("读取完毕");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(objectInputStream!=null){
                        objectInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}