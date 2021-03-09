package com.java.wxg.demo.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-12:02
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Ticket implements Runnable{
    private static int ticketNums = 20;
    private static String LOCK_TICKETS = "锁";
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            synchronized (LOCK_TICKETS){
                if(ticketNums<=0){
                    System.out.println("票卖完了！");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+"买了第"+ticketNums+"张票");
                    ticketNums--;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}