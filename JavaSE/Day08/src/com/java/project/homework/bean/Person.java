package com.java.project.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:30
 * @Since:jdk1.8
 * @Description:作业3 Person类
 */

/**
 * 定义一个人类，id ，name , age 三个属性， 还具备一个自己与他人比较年龄的方法。
 * 类中有属性，可以统计创建人类对象的次数
 */
public class Person {
    private String id;
    private String name;
    private int age;

    /**
     * 与别人比较年龄
     * @param person 别人的对象
     */
    public void compareAge(Person person){
        if(person.age > this.age){
            System.out.println("别人的年龄大");
        }else if(person.age == this.age){
            System.out.println("俩个人年纪一样大");
        }else
            System.out.println("别的年龄小");
    }

    /**
     * 有参构造
     * @param id
     * @param name
     * @param age
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 无参构造
     */
    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}