package com.java.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-18:32
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProduceOrder extends Thread{
    OrderPool orderPool;
    public ProduceOrder(OrderPool orderPool,String name) {
        super(name);
        this.orderPool = orderPool;
    }

    @Override
    public void run() {
        while (true){
            orderPool.produce();
        }
    }
}