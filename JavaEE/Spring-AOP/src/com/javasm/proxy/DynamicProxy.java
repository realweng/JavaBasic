package com.javasm.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-19:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DynamicProxy {
    /**
     * 获取动态代理对象
     * @param o
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Object o,IHandler[] handlers,Class clazz){
        MyInvocation myInvocation = new MyInvocation(o,handlers);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},myInvocation);
    }
}