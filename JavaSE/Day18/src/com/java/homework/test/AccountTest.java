package com.java.homework.test;

import com.java.homework.demo.Account;

import java.util.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:07
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AccountTest {
    /**
     * 延时函数
     */
    public static void delay(){
        //延时
        for (int i = 0; i < 2000000000; i++) {
        }
    }
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        List<Account> list = new ArrayList();
        list.add(new Account(10.00, "1234"));
        delay();//延时创建对象以通过系统时间生成唯一的id
        list.add(new Account(15.00, "5678"));
        delay();//延时创建对象以通过系统时间生成唯一的id
        list.add(new Account(0, "1010"));

        //System.out.println(list.size());
        Map<Long,Account> map = new HashMap<>(16);
        for (int i = 0; i < list.size(); i++) {//将list放入Map中
            map.put(list.get(i).getId(),list.get(i));
        }
        map.forEach((key,value)->{
            System.out.println("id"+key+"\t余额："+value.getBalance());
        });
        //System.out.println(map.size());
    }
}