package com.java.stream.bean;

import java.io.Serializable;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-11:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6919879088569846308L;
    private Integer id;
    private transient String name;

    public User(Integer id, String name) {
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