package com.java.project.project.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-11:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Dept {
    private Integer depId;
    private String depName;

    public Dept(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Dept() {
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