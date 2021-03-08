package com.java.project.project.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:21
 * @Since:jdk1.8
 * @Description:部门实体类
 */
public class Depart {
    private Integer depId;
    private String depName;

    public Depart() {
    }

    public Depart(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}