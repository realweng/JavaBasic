package com.javasm.proxy;

import org.springframework.stereotype.Service;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-19:49
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class Alipay implements Ipay{
    @Override
    public int pay(double money) {
//        System.out.println(1/0);
        System.out.println("支付宝支付"+money+"元");
        return 1;
    }
}