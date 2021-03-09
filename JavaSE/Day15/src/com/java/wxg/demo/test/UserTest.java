package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.User;

import java.util.ArrayList;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-17:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserTest {
    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<User>(10);
        userArrayList.add(new User("111","张三",24,'男'));
        userArrayList.add(new User("112","李四",23,'男'));
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println("第"+(i+1)+"个学生的信息：");
            System.out.println("编号："+userArrayList.get(i).getId());
            System.out.println("姓名："+userArrayList.get(i).getName());
            System.out.println("年龄："+userArrayList.get(i).getAge());
            System.out.println("性别："+userArrayList.get(i).getGrndar());
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("编号 "+"姓名   "+"年龄  "+"性别");
        userArrayList.forEach(user -> {
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getAge()+"\t"+user.getGrndar());
        });
    }
}