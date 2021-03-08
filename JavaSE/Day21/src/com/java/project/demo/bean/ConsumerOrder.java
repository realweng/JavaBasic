package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:42
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ConsumerOrder extends Thread{
    private OrderPool orderPool;
    public ConsumerOrder(OrderPool orderPool,String name) {
        super(name);
        this.orderPool = orderPool;
    }

    @Override
    public void run() {
        while (true){
            orderPool.consumerOrder();
        }
    }
}