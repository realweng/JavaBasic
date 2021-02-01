package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-15:39
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BankException extends Exception{
    public BankException() {
    }

    public BankException(String message) {
        super(message);
    }

    public BankException(String massage,int massageID){
        System.out.println(massage+"  "+massageID);
    }
}