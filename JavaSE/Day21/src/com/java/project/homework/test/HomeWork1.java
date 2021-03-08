package com.java.project.homework.test;

import com.java.project.homework.demo.Demo1;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:56
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println("主线程启动");
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程名字：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("主线程休眠中...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(demo1, "线程1").start();
            new Thread(demo1, "线程2").start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }
}