package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:40
 * @Since:jdk1.8
 * @Description:员工实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工密码
     */
    private String empPwd;
    /**
     * 员工性别
     */
    private String empSex;
    /**
     * 入职时间
     */
    private Date enterTime;
    /**
     * 员工所在部门
     */
    private Integer depId;
    /**
     * 员工所在部门信息
     */
    private Dep dep;
}