package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-16:32
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BinXiang implements Runnable{
    @Override
    public void run() {
        synchronized (ConstantTest.BINXIANG_LOCK){
            System.out.println("冰箱等大象走过来");
            synchronized (ConstantTest.DAXIANG_LOCK){
                System.out.println("冰箱门打开");
            }
        }
    }
}