package com.java.demo.test;

import com.java.demo.bean.ThreadBean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-11:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ThreadBean threadBean = new ThreadBean("线程1");
        ThreadBean threadBean1 = new ThreadBean("线程2");
        ThreadBean threadBean2 = new ThreadBean("线程3");
        threadBean.start();
        threadBean1.start();
        threadBean2.start();
    }
}