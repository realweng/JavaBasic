package com.java.demo.util;

import sun.plugin2.message.Message;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-17:53
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MessageUtil {
    public static String encryption(String string) {
        String secString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes());
            byte[] digest = messageDigest.digest();

            BigInteger bigInteger = new BigInteger(1,digest);
            secString = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return secString;
    }
}