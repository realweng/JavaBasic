package com.java.wxg.homework;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-20:12
 * @Since:jdk1.8
 * @Description:TODO
 */

import java.io.*;
import java.util.Scanner;

/**
 * 4.从控制台进行输入用户名以及用户密码，判断是否登录成功！要求准确的用户名和密码存在配置文件中！
 */
public class HomeWork4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("E:\\login.txt");
        if (!file.exists()) {//如果文件不存在
            OutputStream outputStream = null;
            try {
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                //写入用户名密码
                StringBuffer stringBuffer = new StringBuffer("root admin");
                outputStream.write(stringBuffer.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();//关闭流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //获取文件中的值
        InputStream inputStream = null;
        String strings[] = new String[2];
        try {
            inputStream = new FileInputStream(file);
            int result = 0;
            StringBuffer stringBuffer = new StringBuffer();
            //创建缓冲区
            byte bytes[] = new byte[1024];
            //读取内容
            while ((result = inputStream.read(bytes, 0, bytes.length)) != -1) {
                stringBuffer.append(new String(bytes));
            }
            String s = new String(stringBuffer);
            char chars[] = s.toCharArray();
            //通过空格分割字符串
            strings = s.split(" ");
            StringBuffer stringBuffer1 = new StringBuffer();
            //System.out.println(strings[0]+"\t"+strings[1]);
            char char1[] = strings[1].toCharArray();
            for (char c : char1) {
                if (c != 0) {//字符不是【\u0000】
                    stringBuffer1.append(c);
                } else
                    break;
            }
            strings[1] = stringBuffer1.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("请输入用户名：");
        String name = scanner.next();
        if (name.equals(strings[0])) {
            System.out.println("用户名正确，请输入密码：");
            String pwd = scanner.next();
            System.out.println(strings[1]);
            if (name.equals(strings[0]) && pwd.equals(strings[1])) {
                System.out.println("登录成功！");
            } else
                System.out.println("用户名或密码错误！");
        } else
            System.out.println("用户名错误！");
    }
}