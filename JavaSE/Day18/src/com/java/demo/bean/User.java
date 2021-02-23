package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-16:25
 * @Since:jdk1.8
 * @Description:TODO
 */
public class User implements Comparable<User>{
    private Integer id;

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(User user) {
        return this.id-user.getId();
    }
}