package com.java.stream.test;

import com.java.stream.bean.User;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-11:55
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ObjectDemo {
    public static void main(String[] args) {
        File file = new File("user.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (file.length() <= 0) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false));
                    objectOutputStream.writeObject(new User(1, "111"));
                    objectOutputStream.writeObject(new User(2, "222"));
                    objectOutputStream.writeObject(new User(3, "333"));
                } else {
                    SimpleObjectOutputStream simpleObjectOutputStream = new SimpleObjectOutputStream(new FileOutputStream(file, true));
                    simpleObjectOutputStream.writeObject(new User(4, "111"));
                }
//                User user = (User) objectInputStream.readObject();//读取一个对象
//                System.out.println(user.getId()+"\t"+user.getName());
//                while (true){
//                    User user = (User) objectInputStream.readObject();
//                    System.out.println(user.getId()+"\t"+user.getName());
//                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}