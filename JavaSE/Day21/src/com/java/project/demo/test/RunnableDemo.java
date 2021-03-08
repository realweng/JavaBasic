package com.java.project.demo.test;

import com.java.project.demo.bean.RunnableBean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-11:56
 * @Since:jdk1.8
 * @Description:TODO
 */
public class RunnableDemo {
    public static void main(String[] args) {
        RunnableBean runnableBean = new RunnableBean();
        new Thread(runnableBean, "线程1").start();
        new Thread(runnableBean, "线程2").start();
        new Thread(runnableBean, "线程3").start();
    }
}