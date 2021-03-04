package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-17:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class User {
    private Integer userId;
    private String userName;
    private String userGender;
    private Integer userAge;
    private String userAddr;

    public User() {
    }

    public User(Integer userId, String userName, String userGender, Integer userAge, String userAddr) {
        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userAddr = userAddr;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }
}