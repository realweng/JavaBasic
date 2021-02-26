package com.java.demo.bean;

import java.util.concurrent.Callable;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-16:41
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CallableDemo implements Callable<String> {
    private static int tickets = 10;

    @Override
    public String call() throws Exception {
        while (true) {
            synchronized ("锁") {
                if (tickets <= 0) {
                    System.out.println("票卖完了");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName()+"抢了第"+tickets+"张票");
                    tickets--;
                    Thread.sleep(300);
                }
            }
        }
        return "执行完毕";
    }
}