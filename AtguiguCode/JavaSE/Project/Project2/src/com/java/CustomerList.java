package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-20:47
 * @Since:jdk1.8
 * @Description:TODO
 */
/*
*CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
*并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 */
public class CustomerList {
    private int total ; //记录存储的客户的个数
    private Customer[] customers = new Customer[total];

    /**
     * 用途：构造器，用来初始化customers数组
     * @param totalCustomer 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 用途：将参数customer添加到数组中最后一个客户对象记录之后
     * @param customer customer指定要添加的客户对象
     * @return 添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if(customer != null && total < customers.length){

        }
        return false;
    }

    /**
     * 用途：用参数customer替换数组中由index指定的对象
     * @param index 指定所替换对象在数组中的位置，从0开始
     * @param cust customer指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust){
        return true;
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     * @param index 指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        return true;
    }

    /**
     * 用途：返回数组中记录的所有客户对象
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
     */
    public Customer[] getAllCustomers(){
        return null;
    }

    /**
     * 用途：返回参数index指定索引位置的客户对象记录
     * @param index  index指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        return null;
    }

    /**
     * 返回Customer对象的个数
     * @return
     */
    public int getTotal(){
        return total;
    }

}