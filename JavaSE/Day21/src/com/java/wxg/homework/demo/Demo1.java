package com.java.wxg.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo1 implements Runnable{
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"休眠中....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}