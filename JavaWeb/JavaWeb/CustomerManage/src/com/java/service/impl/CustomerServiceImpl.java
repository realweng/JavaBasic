package com.java.service.impl;

import com.java.dao.CustomerDao;
import com.java.dao.impl.CustomerDaoImpl;
import com.java.entity.Customer;
import com.java.service.CustomerService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    /**
     * 管理员登录
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public List<Customer> CustomerLogin(String name, String pwd) {
        return customerDao.CustomerLogin(name,pwd);
    }

    /**
     * 管理员注册
     *
     * @param customer
     * @return
     */
    @Override
    public int CustomerRegister(Customer customer) {
        return customerDao.CustomerRegister(customer);
    }

    /**
     * 通过姓名查找用户
     *
     * @param name
     * @return
     */
    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerDao.findCustomerByName(name);
    }
}