package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-17:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}