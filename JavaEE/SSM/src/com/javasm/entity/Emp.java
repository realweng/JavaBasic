package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:03
 * @Since:jdk1.8
 * @Description:TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer empId;
    private String empName;
    private String empPwd;
    private String empSex;
    private Integer depId;
    private Date enterTime;
    /**
     * 当前员工所在的部门
     */
    private Dep dep;
}