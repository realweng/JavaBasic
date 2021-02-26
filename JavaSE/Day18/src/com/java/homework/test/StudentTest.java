package com.java.homework.test;

import com.java.homework.demo.Student;

import java.util.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-18:30
 * @Since:jdk1.8
 * @Description:TODO
 */
public class StudentTest {
    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();//自然顺序存储，第一个就是最小值，最后一个就是最大值
        ArrayList<Integer> list = new ArrayList<>(20);//存放随机数
        int i = 0;
        //产生20个【1-40】不重复的随机数
        while (list.size() < 20) {
            int num = (int) (Math.random() * 40 + 1);
            if (list.indexOf(num) == -1) { //随机数还没出现过
                list.add(num);
            } else continue;
        }
        System.out.println(list);
        //将数据存入set中
        for (int j = 0; j < list.size(); j++) {
            set.add(new Student(list.get(j),(int)(Math.random() * 101)));
        }
        set.forEach(student -> {
            System.out.println(student);
        });

        System.out.println("最小："+set.first());
        System.out.println("最大："+set.last());
    }
}