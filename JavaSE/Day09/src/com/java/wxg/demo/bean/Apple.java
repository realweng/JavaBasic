package com.java.wxg.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-11:40
 * @Since:jdk1.8
 * @Description:TODO
 */

public class Apple {
    private int size;

    public Apple appleEat(){
        System.out.println("苹果吃之前要削皮");
        return this;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}