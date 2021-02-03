package com.java.demo.util;

import java.util.Base64;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:47
 * @Since:jdk1.8
 * @Description:Base64加密工具类
 */
public class Base64Util {
    /**
     * Base64加密
     * @param string 传入的字符串
     * @return 返回加密后的字符串
     */
    public static String encryption(String string) {
        Base64.Encoder encoder = Base64.getEncoder();// 获得编码器
        String encodePass = encoder.encodeToString(string.getBytes());
        //System.out.println(encodePass);
        return encodePass;//返回加密后的字符
    }

    /**
     * Base64 解密
     * @param string 传入被加密的字符串
     * @return 返回解密后的字符串
     */
    public static String decryption(String string){
        Base64.Decoder decoder = Base64.getDecoder();// 获得解码器
        byte[] by = decoder.decode(string);
        String str = new String(by);
        return str;
    }
}