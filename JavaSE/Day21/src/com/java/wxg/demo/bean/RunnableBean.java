package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-11:56
 * @Since:jdk1.8
 * @Description:TODO
 */
public class RunnableBean implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}