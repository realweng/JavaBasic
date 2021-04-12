package com.javasm.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/10-20:07
 * @Since:jdk1.8
 * @Description:通用的DAO抽象接口
 */
public interface BaseDao<T> {
    /**
     * 增
     * @param t
     */
    boolean add(T t);

    /**
     * 通过id删
     * @param t
     */
    boolean delete(T t);

    /**
     * 改
     * @param t
     */
    boolean update(T t);

    /**
     * 查
     * @param t
     * @return
     */
    T select(T t);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();
}