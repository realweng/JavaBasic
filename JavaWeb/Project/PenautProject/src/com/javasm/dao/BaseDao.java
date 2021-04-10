package com.javasm.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/10-20:07
 * @Since:jdk1.8
 * @Description:BaseDao通用的DAO抽象接口
 */
public interface BaseDao<T> {
    /**
     * 增
     * @param t
     */
    void add(T t);

    /**
     * 删
     * @param t
     */
    void delete(T t);

    /**
     * 改
     * @param t
     */
    void update(T t);

    /**
     * 查
     * @param t
     * @return
     */
    T select(T t);
}