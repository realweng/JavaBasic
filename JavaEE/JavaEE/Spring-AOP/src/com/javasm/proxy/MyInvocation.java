package com.javasm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-19:39
 * @Since:jdk1.8
 * @Description:执行代理对象的方法
 */
public class MyInvocation implements InvocationHandler, IHandler {
    private Object object;
    private IHandler[] iHandlers;

    public MyInvocation(Object object, IHandler[] iHandlers) {
        this.object = object;
        this.iHandlers = iHandlers;
    }

    /**
     * 执行代理对象的方法
     *
     * @param proxy
     * @param method 代理对象的方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ProxyMethod proxyMethod = new ProxyMethod(method,args);
        Object returnVal = null;
        doBefore(proxyMethod);
        try {
            returnVal = method.invoke(object, args);
            doReturn(proxyMethod);
        } catch (Exception e) {
            e.printStackTrace();
            doError(proxyMethod);
        } finally {
            doAfter(proxyMethod);
        }
        return returnVal;
    }

    @Override
    public void doBefore(ProxyMethod proxyMethod) {
        for (IHandler iHandler : iHandlers) {
            iHandler.doBefore(proxyMethod);
        }
    }

    @Override
    public void doAfter(ProxyMethod proxyMethod) {
        for (IHandler iHandler : iHandlers) {
            iHandler.doAfter(proxyMethod);
        }
    }

    @Override
    public void doReturn(ProxyMethod proxyMethod) {
        for (IHandler iHandler : iHandlers) {
            iHandler.doReturn(proxyMethod);
        }
    }

    @Override
    public void doError(ProxyMethod proxyMethod) {
        for (IHandler iHandler : iHandlers) {
            iHandler.doError(proxyMethod);
        }
    }
}