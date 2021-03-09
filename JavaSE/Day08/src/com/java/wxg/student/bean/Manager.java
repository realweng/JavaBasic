package com.java.wxg.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:49
 * @Since:jdk1.8
 * @Description:作业5 管理员类
 */
public class Manager {
    private String userName = "123";
    private String password = "123";

    /**
     * 显示管理员信息
     */
    public void show(){
        System.out.println("用户名"+userName);
        System.out.println("密码"+password);
    }

    /**
     * 验证用户名密码是否正确
     */
    public boolean confirm(String userName,String password){
        if(this.userName.equals(userName)&&this.password.equals(password)){
            System.out.println("用户名密码正确！");
            return true;
        }else
            System.out.println("用户名或密码错误！");
        return false;
    }

    /**
     * 有参构造
     * @param userName
     * @param password
     */
    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * 无参构造
     */
    public Manager() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}