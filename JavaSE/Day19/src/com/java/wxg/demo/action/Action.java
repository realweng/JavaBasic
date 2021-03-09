package com.java.wxg.demo.action;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-15:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface Action<E> {
    public void add(E e);
    public List<E> findAll();
    public void delete(E e);
    public E getById(int id);
}