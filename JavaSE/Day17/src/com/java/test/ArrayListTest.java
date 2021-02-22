package com.java.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/22-10:13
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList(10);
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        System.out.println(list);
        System.out.println("---------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---------------------");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("---------------------");

        list.forEach(name -> {
            System.out.println(name);
        });
        System.out.println("--------------------");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------");

        List list1 = list.subList(0, list.size() - 2);
        System.out.println(list1);
    }
}