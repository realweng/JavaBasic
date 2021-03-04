package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProduceOrder extends Thread{
    private OrderPool orderPool;
    public ProduceOrder(OrderPool orderPool,String name){
        super(name);
        this.orderPool = orderPool;
    }

    @Override
    public void run() {
        while (true){
            orderPool.produceOrder();
        }
    }
}