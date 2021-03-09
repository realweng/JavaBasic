package com.java.wxg.socketdemo.thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-16:18
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ReadThread extends Thread {
    private Socket socket;

    public ReadThread(String name, Socket socket) {
        super(name);
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println("对方说："+dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}