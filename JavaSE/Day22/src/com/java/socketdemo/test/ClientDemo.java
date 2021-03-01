package com.java.socketdemo.test;

import com.java.socketdemo.constants.SocketConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-15:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClientDemo {
    /**
     * 客户端
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", SocketConstant.PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("服务端你好");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Server说：" + dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}