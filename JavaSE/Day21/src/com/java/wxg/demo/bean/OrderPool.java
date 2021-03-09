package com.java.wxg.demo.bean;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class OrderPool {
    private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    //生产者放入订单

    public synchronized void produceOrder() {
        if (list.size() == 30) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满就将订单放入订单池
        list.add("order");
        System.out.println(Thread.currentThread().getName() + "----------------生产1个，还有" + list.size() + "个");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //有订单了就提醒消费者消费
        this.notifyAll();
    }

    //消费者消费订单
    public synchronized void consumerOrder() {
        if (list.size() == 0) {
            System.out.println("订单池没有订单，消费者等待");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //订单里面有内容，先消费缓冲区里的第一个
        list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费了1个，还有："+list.size()+"个");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完了，池子里面就有多余的空间 让生产者生产
        this.notifyAll();
    }
}