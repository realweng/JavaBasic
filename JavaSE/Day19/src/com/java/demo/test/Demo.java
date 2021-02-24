package com.java.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-11:56
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo<T extends Number> implements DemoInterface<T> {
    @Override
    public void add(T t) {

    }

    @Override
    public void replace(T t) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void showArray(T[] ts) {
        for (T t : ts) {
            System.out.println(t+"\t");
        }
        System.out.println();
    }
}