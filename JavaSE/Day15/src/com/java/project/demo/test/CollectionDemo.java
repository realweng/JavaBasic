package com.java.project.demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-11:57
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add("555");
        collections.add('g');
        collections.add(1.95);
        collections.add(true);
        collections.add("测试");

        if(!collections.isEmpty()){
            for (Object o : collections) {
                System.out.println(o);
            }

            for (int i = 0; i < collections.size(); i++) {
                System.out.println(((ArrayList) collections).get(i));
            }

            Iterator iterator = collections.iterator();
            while (iterator.hasNext()){
                Object o = iterator.next();
                System.out.println(o);
            }

        }


    }
}