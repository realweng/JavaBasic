package com.java.wxg.socketdemo.test;

import com.java.wxg.socketdemo.constants.SocketConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/1-15:35
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ServerDemo {
    /**
     * 服务端
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(SocketConstant.PORT);
            //等待服务端请求
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功！");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println("Client说："+dataInputStream.readUTF());

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("客户端你好");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}