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
}