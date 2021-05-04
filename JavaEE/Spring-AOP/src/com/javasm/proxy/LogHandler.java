package com.javasm.proxy;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:15
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LogHandler implements IHandler{
    @Override
    public void doBefore(ProxyMethod proxyMethod) {
        System.out.println("日志工具类 方法 : " + proxyMethod.getMethod().getName() + " ,参数 : " + proxyMethod.getArgs());
    }

    @Override
    public void doAfter(ProxyMethod proxyMethod) {

    }

    @Override
    public void doError(ProxyMethod proxyMethod) {

    }

    @Override
    public void doReturn(ProxyMethod proxyMethod) {

    }
}