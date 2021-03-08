package com.java.project.demo.test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-10:32
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(111);
        treeSet.add(131);
        treeSet.add(141);
        treeSet.add(211);
        treeSet.add(101);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}