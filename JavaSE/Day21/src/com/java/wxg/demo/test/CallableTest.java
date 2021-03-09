package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.CallableDemo;

import java.util.concurrent.FutureTask;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:26
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CallableTest {
    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask(callableDemo);
        FutureTask futureTask1 = new FutureTask(callableDemo);
        FutureTask futureTask2 = new FutureTask(callableDemo);
        new Thread(futureTask,"aaa").start();
        new Thread(futureTask1,"bbb").start();
        new Thread(futureTask2,"ccc").start();
    }
}