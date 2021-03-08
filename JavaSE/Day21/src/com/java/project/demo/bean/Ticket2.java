package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-15:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Ticket2 implements Runnable {
    private int ticketNums = 20;
    private static String LOCK_TICKETS = "锁";

    @Override
    public void run(){
        while (true) {
            boolean flag = test();
            if (flag == false) {
                break;
            }
        }
    }

    private synchronized boolean test() {
        if (ticketNums <= 0) {
            System.out.println("票卖完了！");
            return false;
        }
        System.out.println(Thread.currentThread().getName() + "买了第" + ticketNums + "张票");
        ticketNums--;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}