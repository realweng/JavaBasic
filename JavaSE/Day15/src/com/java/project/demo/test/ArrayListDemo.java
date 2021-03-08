package com.java.project.demo.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-15:12
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(123);
        arrayList.add("测试");
        arrayList.add('a');
        arrayList.add(1.99);
        arrayList.add(true);
        arrayList.add("abcd");

        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println("-------------------");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("---------------------");

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");

        //修改
        arrayList.set(2,'d');
        //添加
        arrayList.add(3,"111111");

        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println("-------------------");

        //删除
        arrayList.remove(6);
        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println("-------------------");
        //清空
        arrayList.clear();

        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println("-------------------");

    }
}