package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-11:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ThreadBean extends Thread{
    public ThreadBean(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}