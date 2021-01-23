package com.java;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/22-20:46
 * @Since:jdk1.8
 * @Description:Customer为实体对象，用来封装客户信息
 */

 /**
  * Customer为实体对象，用来封装客户信息
  */
public class Customer {
    private String name;    //姓名
    private char gender;    //性别
    private int age;        //年龄
    private String phone;   //电话
    private String email;   //电子邮箱

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

     /**
      * 构造器
      */
     public Customer(String name, char gender, int age, String phone, String email) {
         this.name = name;
         this.gender = gender;
         this.age = age;
         this.phone = phone;
         this.email = email;
     }
     //测试
//     public static void main(String[] args) {
//         Customer cs = new Customer();
//         cs.setAge(18);
//         cs.setGender('男');
//         System.out.println(cs.getAge()+" "+ cs.getGender());
//     }
 }