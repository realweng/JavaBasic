package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-20:46
 * @Since:jdk1.8
 * @Description:TODO
 */
/*
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer cust = new Customer("张三", '男', 30, "010-12345678", "zs@gmail.com");
        customerList.addCustomer(cust);
    }

    /**
     * 用途：显示主菜单，响应用户输入，
     * 根据用户操作分别调用其他相应的成员方法
     * （如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("------------客户信息管理软件--------------");
            System.out.println("              1 添加客户");
            System.out.println("              2 修改客户");
            System.out.println("              3 删除客户");
            System.out.println("              4 客户列表");
            System.out.println("              5 退    出");
            System.out.println("请选择(1-5)；");
            char select = CMUtility.readMenuSelection();
            switch (select) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("是否确认退出：（Y/N）");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * 添加客户的菜单功能
     */
    private void addNewCustomer() {
        System.out.println("--------------------添加客户--------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱：");
        String email = CMUtility.readString(16);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSucess = customerList.addCustomer(customer);
        if (isSucess) {
            System.out.println("添加成功！");
        } else
            System.out.println("添加失败！");
    }

    /**
     * 修改客户的菜单功能
     */
    private void modifyCustomer() {
        Customer customer = null;
        int index = 0;
        System.out.println("------------------修改客户信息------------------");
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("请选择待修改客户的编号(-1退出)");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }
            customer = customerList.getCustomer(index - 1);
            if (customer == null) {
                System.out.println("无法找到指定的客户");
            } else {
                //System.out.println("找到了");
                break;
            }
        }
        //姓名
        System.out.println("姓名" + "(" + customer.getName() + "):");
        String name = CMUtility.readString(10, customer.getName());
        //性别
        System.out.println("性别" + "(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        //年龄
        System.out.println("年龄" + "(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        //电话
        System.out.println("电话" + "(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(11, customer.getPhone());
        //邮箱
        System.out.println("邮箱" + "(" + customer.getEmail() + "):");
        String email = CMUtility.readString(11, customer.getEmail());
        Customer cust = new Customer(name, gender, age, phone, email);
        boolean isRepalaced = customerList.replaceCustomer(index - 1, cust);
        if (isRepalaced) {
            System.out.println("修改完成！");
            isFlag = false;
        } else
            System.out.println("修改失败");
    }

    /**
     * 删除客户的菜单功能
     */
    private void deleteCustomer() {
        System.out.println("--------------------删除客户--------------------");
        int index = 0;
        Customer customer;
        while (true) {
            System.out.println("请选择待删除客户编号（-1退出）：");
            index = CMUtility.readInt();
            if (index == -1) {
                System.out.println("退出");
                return;
            } else {
                customer = customerList.getCustomer(index - 1);
                if(customer == null){
                    System.out.println("没有找到该用户");
                }else {
                    break;
                }
            }
        }
        System.out.println("确认是否删除（Y/N）：");
        char confirm = CMUtility.readConfirmSelection();
        if(confirm == 'Y'){
            customerList.deleteCustomer(index-1);
        }
    }

    /**
     * 客户列表的菜单功能
     */
    private void listAllCustomers() {
        System.out.println("--------------------客户列表--------------------");
        if (customerList.getTotal() == 0) {
            System.out.println("没有客户记录");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                System.out.println((i + 1) + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" +
                        custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
            }
        }
        System.out.println("------------------客户列表完成-------------------");

    }

    /**
     * 用途：创建CustomerView实例，
     * 并调用 enterMainMenu()方法以执行程序。
     *
     * @param args
     */
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}