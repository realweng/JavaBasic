package com.javasm.proxy;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:02
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface IHandler {
    void doBefore(ProxyMethod proxyMethod);
    void doAfter(ProxyMethod proxyMethod);
    void doReturn(ProxyMethod proxyMethod);
    void doError(ProxyMethod proxyMethod);
}
