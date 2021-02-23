package com.java.demo.test;

import java.util.LinkedHashSet;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-10:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>(16);
        linkedHashSet.add(111);
        linkedHashSet.add(121);
        linkedHashSet.add(113);
        linkedHashSet.add(11);
        for (Object o : linkedHashSet) {
            System.out.println(o);
        }
    }
}