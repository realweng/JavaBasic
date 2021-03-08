package com.java.project.project.bean;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:22
 * @Since:jdk1.8
 * @Description:打卡实体类
 */
public class ClockIn {
    private Integer clockId;
    private Integer empId;
    private Date clockTime;
    private Integer clockFlag;

    public ClockIn() {
    }

    public ClockIn(Integer clockId, Integer empId, Date clockTime, Integer clockFlag) {
        this.clockId = clockId;
        this.empId = empId;
        this.clockTime = clockTime;
        this.clockFlag = clockFlag;
    }

    public Integer getClockId() {
        return clockId;
    }

    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getClockTime() {
        return clockTime;
    }

    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    public Integer getClockFlag() {
        return clockFlag;
    }

    public void setClockFlag(Integer clockFlag) {
        this.clockFlag = clockFlag;
    }
}