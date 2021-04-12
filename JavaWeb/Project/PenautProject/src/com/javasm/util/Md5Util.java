package com.javasm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-9:33
 * @Since:jdk1.8
 * @Description:MD5加密工具类
 */
public class Md5Util {
    public static String encode(String str){
        String encodeStr = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, digest);
            encodeStr = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
}