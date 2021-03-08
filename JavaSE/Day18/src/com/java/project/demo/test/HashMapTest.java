package com.java.project.demo.test;

import java.util.HashMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-11:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>(16);
        hashMap.put(1,"A111");
        hashMap.put(2,"B222");
        hashMap.put(3,"C333");
        hashMap.put(4,"D444");
        hashMap.put(5,"E555");
        hashMap.put(6,"F666");
        System.out.println(hashMap);
        System.out.println("获取key为1的值："+hashMap.get(1));
        System.out.println("通过key来获取值："+ hashMap.getOrDefault(7,"没有找到，这个key不存在"));
        System.out.println("通过key来移除："+hashMap.remove(3));
        System.out.println(hashMap);
        System.out.println("通过key和value来移除"+hashMap.remove(4,"C444"));
        System.out.println(hashMap);
        System.out.println("通过key来替换："+hashMap.replace(1, "M1111"));
        System.out.println(hashMap);
        System.out.println("通过key和value来替换："+hashMap.replace(5,"E555","N555"));
        System.out.println(hashMap);
        if(hashMap.containsKey(4)){
            System.out.println("存在key为4的HashMap");
        }else {
            System.out.println("不存在");
        }

        //遍历
        hashMap.forEach((key,val)->{
            System.out.print("key:"+key+"\t");
            System.out.println("value:"+val);
        });
    }
}