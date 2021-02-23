package com.java.demo.test;

import com.java.demo.bean.Student1;
import com.java.demo.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-16:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ListSort {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>(10);
        list.add(new User(1));
        list.add(new User(3));
        list.add(new User(2));
        list.add(new User(8));
        list.add(new User(6));
        Collections.sort(list);
        list.forEach(user -> {
            System.out.println(user.getId());
        });

        List<Student1> list1 = new ArrayList<>(10);
        list1.add(new Student1(1, "111", 40));
        list1.add(new Student1(2, "121", 50));
        list1.add(new Student1(4, "141", 60));
        list1.add(new Student1(3, "131", 10));
        list1.add(new Student1(0, "101", 90));
        Collections.sort(list1, new Comparator <Student1> () {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o1.getId() - o2.getId();
            }
        });
        list1.forEach(student -> {
            System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getGrade());
        });
    }
}