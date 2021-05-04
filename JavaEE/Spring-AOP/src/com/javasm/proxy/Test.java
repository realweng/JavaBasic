package com.javasm.proxy;

import sun.net.www.content.audio.wav;

import java.util.logging.Handler;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-19:55
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Test {
    public static void main(String[] args) {
        IHandler handlers[] = new IHandler[]{new LogHandler(),new TimeHandler()};
        // 获取代理对象
        Ipay proxy = DynamicProxy.getProxy(new WxPay(),handlers,Ipay.class);
        proxy.pay(100);
    }
}