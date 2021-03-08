package com.java.project.demo.test;

import com.java.project.demo.bean.Ticket;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-12:02
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"yh1").start();
        new Thread(ticket,"yh2").start();
        new Thread(ticket,"yh3").start();
    }
}