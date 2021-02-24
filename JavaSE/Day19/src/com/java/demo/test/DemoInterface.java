package com.java.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-11:57
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface DemoInterface <T>{
    public void add(T t);
    public void replace(T t);
    public void delete(T t);

    /**
     * 遍历
     * @param ts
     */
    public void showArray(T [] ts);
}
