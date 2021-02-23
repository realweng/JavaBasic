package com.java.demo.test;

import com.java.demo.bean.User;

import java.util.TreeMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-16:24
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<User,String> treeMap = new TreeMap<>();
        treeMap.put(new User(1),"111");
        treeMap.put(new User(2),"122");
        treeMap.put(new User(6),"133");
        treeMap.put(new User(4),"144");
        treeMap.put(new User(5),"155");
        treeMap.forEach((key,val)->{
            System.out.println("key:"+key.getId()+"\t"+"value:"+val);
        });
    }
}