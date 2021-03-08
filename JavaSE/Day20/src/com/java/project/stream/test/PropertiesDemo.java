package com.java.project.stream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-15:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("user.propertie")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("user.pass"));
    }
}