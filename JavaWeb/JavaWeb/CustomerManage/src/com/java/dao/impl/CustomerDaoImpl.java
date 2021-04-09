package com.java.dao.impl;

import com.java.dao.CustomerDao;
import com.java.entity.ClassInfo;
import com.java.entity.Customer;
import com.java.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CustomerDaoImpl implements CustomerDao {
    /**
     * 管理员登录
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public List<Customer> CustomerLogin(String name, String pwd) {
        String sql = "select * from customer where customerName = ? and pwd = ?";
        return JDBCUtil.query(sql,Customer.class,name,pwd);
    }

    /**
     * 管理员注册
     *
     * @param customer
     * @return
     */
    @Override
    public int CustomerRegister(Customer customer) {
        String sql = "INSERT INTO `customer` VALUES(null,?,?)";
        return JDBCUtil.update(sql,customer.getCustomerName(),customer.getPwd());
    }

    /**
     * 通过姓名查找用户
     *
     * @param name
     * @return
     */
    @Override
    public List<Customer> findCustomerByName(String name) {
        String sql = "select * from customer where customerName=?";
        return JDBCUtil.query(sql,Customer.class,name);
    }
}