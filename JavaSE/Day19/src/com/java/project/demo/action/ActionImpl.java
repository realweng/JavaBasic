package com.java.project.demo.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-15:11
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ActionImpl<E> implements Action<E> {

    List<E> list = new ArrayList<>(10);
    public ActionImpl(List<E> list) {
        this.list = list;
    }
    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public List<E> findAll() {
        return list;
    }

    @Override
    public void delete(E e) {
        list.remove(e);
    }

    @Override
    public E getById(int id) {
        E e = list.get(id);
        return e;
    }
}