package com.java.demo.test;

import com.java.demo.bean.BinXiang;
import com.java.demo.bean.DaXiang;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-16:36
 * @Since:jdk1.8
 * @Description:死锁测试
 */
public class LockTest {
    public static void main(String[] args) {
        BinXiang binXiang = new BinXiang();
        DaXiang daXiang = new DaXiang();
        new Thread(binXiang).start();
        new Thread(daXiang).start();
    }
}