package com.java.service;

import com.java.entity.Customer;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:20
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface CustomerService {
    /**
     * 管理员登录
     * @param name
     * @param pwd
     * @return
     */
    public List<Customer> CustomerLogin(String name, String pwd);

    /**
     * 管理员注册
     * @param customer
     * @return
     */
    public int CustomerRegister(Customer customer);

    /**
     * 通过姓名查找用户
     * @param name
     * @return
     */
    public List<Customer> findCustomerByName(String name);
}