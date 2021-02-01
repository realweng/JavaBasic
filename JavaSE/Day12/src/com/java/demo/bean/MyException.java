package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-15:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String massage,int massageId){
        super(massage);
        System.out.println("错误的信息为："+massage+" "+"错误信息的编码："+massageId);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}