package com.java.wxg.socketdemo.test;

import com.java.wxg.socketdemo.constants.SocketConstant;
import com.java.wxg.socketdemo.thread.ReadThread;
import com.java.wxg.socketdemo.thread.WriteThread;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-16:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",SocketConstant.PORT);
            new WriteThread("客户端线程",socket).start();
            new ReadThread("客户端线程",socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}