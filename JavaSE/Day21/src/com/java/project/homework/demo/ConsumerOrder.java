package com.java.project.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-18:32
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ConsumerOrder extends Thread {
    OrderPool orderPool;

    public ConsumerOrder(OrderPool orderPool, String name) {
        super(name);
        this.orderPool = orderPool;
    }

    @Override
    public void run() {
        while (true){
            orderPool.consumer();
        }
    }
}