package com.java.socketdemo.test;

import com.java.socketdemo.constants.SocketConstant;
import com.java.socketdemo.thread.ReadThread;
import com.java.socketdemo.thread.WriteThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-16:25
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SocketConstant.PORT);
            Socket socket = serverSocket.accept();
            new WriteThread("服务器线程",socket).start();
            new ReadThread("服务器线程",socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}