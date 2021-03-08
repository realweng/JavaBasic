package com.java.project.project.bean;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:21
 * @Since:jdk1.8
 * @Description:员工实体类
 */
public class Emp {
    private Integer empId;
    private String empUname;//用户名
    private String empPwd;
    private String empName;
    private String empGender;
    private Integer depId;
    private Date empDate;//入职时间

    public Emp() {
    }

    public Emp(Integer empId, String empUname, String empPwd, String empName, String empGender, Integer depId, Date empDate) {
        this.empId = empId;
        this.empUname = empUname;
        this.empPwd = empPwd;
        this.empName = empName;
        this.empGender = empGender;
        this.depId = depId;
        this.empDate = empDate;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpUname() {
        return empUname;
    }

    public void setEmpUname(String empUname) {
        this.empUname = empUname;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Date getEmpDate() {
        return empDate;
    }

    public void setEmpDate(Date empDate) {
        this.empDate = empDate;
    }
}