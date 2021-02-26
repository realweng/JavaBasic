package com.java.demo.test;

import com.java.demo.bean.ConsumerOrder;
import com.java.demo.bean.OrderPool;
import com.java.demo.bean.ProduceOrder;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-17:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class OrderTest {
    public static void main(String[] args) {
        OrderPool orderPool = new OrderPool();
        new ProduceOrder(orderPool,"生产者线程").start();
        new ConsumerOrder(orderPool,"消费者线程").start();
    }
}