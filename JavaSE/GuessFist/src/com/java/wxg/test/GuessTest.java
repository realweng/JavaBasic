package com.java.wxg.test;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/30-13:32
 * @Since:jdk1.8
 * @Description:猜拳项目测试类
 */
public class GuessTest {
    static Scanner sc = new Scanner(System.in);
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
       Game game = new Game();
       game.startGame();
    }
}