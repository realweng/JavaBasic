package com.javasm.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:16
 * @Since:jdk1.8
 * @Description:代理对象方法的相关信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProxyMethod {
    /**
     * 方法信息
     */
    private Method method;
    /**
     * 方法参数
     */
    private Object[] args;

    /**
     * 返回类型
     */
    private Object returnVal;

    /**
     * 异常类型
     */
    private Exception e;

    /**
     * 构造方法
     * @param method
     * @param args
     */
    public ProxyMethod(Method method, Object[] args) {
        this.method = method;
        this.args = args;
    }

}