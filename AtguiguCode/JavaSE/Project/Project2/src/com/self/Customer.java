package com.self;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-21:37
 * @Since:jdk1.8
 * @Description:客户类
 */
public class Customer {
    private String name; //客户姓名
    private char gender; //性别
    private int age; //年龄
    private String phone; //电话号码
    private String email; //电子邮件

    /**
     * 有参构造器
     * @param name
     * @param gender
     * @param age
     * @param phone
     * @param email
     */
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}