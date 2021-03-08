package com.java.project.demo.test;

import com.java.project.demo.bean.Ticket2;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-15:41
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(ticket,"yh1").start();
        new Thread(ticket,"yh2").start();
        new Thread(ticket,"yh3").start();
    }
}