package com.java.wxg.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:24
 * @Since:jdk1.8
 * @Description:作业2 自定义的异常类
 */
public class StoreException extends Exception{
    public StoreException() {
    }

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(Throwable cause) {
        super(cause);
    }

    public StoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}