package com.java.project.demo.test;

import java.util.HashSet;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-10:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>(16);
        hashSet.add("12");
        hashSet.add("16");
        hashSet.add("15");
        hashSet.add("14");
        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
}