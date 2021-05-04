package com.javasm.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-22:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class XmlAop {
    public void doBefore(JoinPoint joinPoint){
        System.out.println("前置通知。。。");
    }

    public void doAfter(JoinPoint joinPoint){
        System.out.println("后置通知。。。");
    }

    public void doReturn(Object returnVal){
        System.out.println("返回通知"+returnVal);
    }
}