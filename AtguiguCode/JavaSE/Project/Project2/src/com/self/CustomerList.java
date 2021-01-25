package com.self;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-21:37
 * @Since:jdk1.8
 * @Description:客户数组，在数据层实现对数据的增删改查
 */
public class CustomerList {
    private int total; //当前List里面的人数
    Customer [] customers = new Customer[total]; //动态初始化

    /**
     * CustomerList构造器 初始化customer数组对象
     * @param totalCustomer 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 往数组中加客户信息
     * @param customer 要加入数组的对象
     * @return 判断是否加入成功
     */
    public boolean addCustomer(Customer customer){
        if(customer != null && total < customers.length){
            customers[total] = customer;
            total++;
            return true;
        }
        return false;
    }

    /**
     * 修改指定索引的客户信息
     * @param index 索引
     * @param cust 指定替换新客户对象
     * @return 判断
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total){
            System.out.println("索引超出正常范围");
            return false;
        }else {
            for (int i = 0; i < total; i++) {
                if(i == index - 1){
                    customers[i] = cust;
                    break;
                }
            }
            return true;
        }
    }

    /**
     * 删除指定索引位置的对象
     * @param index 索引
     * @return
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            System.out.println("索引超出正常范围");
            return false;
        }else{
            for (int i = index-1; i < total-1; i++) {
                customers[i] = customers[i+1];
            }
            customers[total] = null;
            total--;
            return true;
        }
    }

    /**
     * 获取所有客户的对象
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer cust[] = new Customer[total];
        for (int i = 0; i < total; i++) {
            cust[i] = customers[i];
        }
        return cust;
    }

    /**
     * 获取指定索引的客户
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        Customer customer = new Customer();
        if(index >= total || index < 0){
            System.out.println("索引超出上限");
            return null;
        }else {
            for (int i = 0; i < total; i++) {
                if(i == index-1){
                    customer = customers[i];
                    break;
                }
            }
            return customer;
        }
    }

    /**
     * 获取当前数组非空对象个数
     * @return
     */
    public int getTotal(){
        return total;
    }
}