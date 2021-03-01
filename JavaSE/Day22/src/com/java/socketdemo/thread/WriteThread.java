package com.java.socketdemo.thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-16:21
 * @Since:jdk1.8
 * @Description:TODO
 */
public class WriteThread extends Thread{
    private Socket socket;
    Scanner scanner = new Scanner(System.in);

    public WriteThread(String name, Socket socket) {
        super(name);
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                dataOutputStream.writeUTF(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}