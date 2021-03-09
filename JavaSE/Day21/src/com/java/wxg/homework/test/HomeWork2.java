package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-18:30
 * @Since:jdk1.8
 * @Description:TODO
 */

import com.java.wxg.homework.demo.ConsumerOrder;
import com.java.wxg.homework.demo.OrderPool;
import com.java.wxg.homework.demo.ProduceOrder;

/**
 * 结合生产者与消费者模式编写如下程序：
 * 生产者随机时间（0.5-1.5秒）产生随机的字符串，
 * 消费者由线程担任，假设每处理一个字符串需要2-3秒时间
 */
public class HomeWork2 {
    public static void main(String[] args) {
        OrderPool orderPool = new OrderPool();
        new ConsumerOrder(orderPool,"消费者线程").start();
        new ProduceOrder(orderPool,"生产者线程").start();
    }
}