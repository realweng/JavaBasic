package com.java.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-10:17
 * @Since:jdk1.8
 * @Description:密码加密工具类
 */
public class MD5Util {
    public static String encryption(String pwd){
        // 1.获得messageDigest对象
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            // 2.传输需要加密数据
            messageDigest.update(pwd.getBytes());
            // 3.加密
            byte[] encodeBy = messageDigest.digest();
//            System.out.println(Arrays.toString(encodeBy));
            // 将字节数组转换成BigInteger实例
            BigInteger bigInteger = new BigInteger(1, encodeBy);
            pwd = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pwd;
    }
}