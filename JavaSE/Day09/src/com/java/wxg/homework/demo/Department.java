package com.java.wxg.homework.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:51
 * @Since:jdk1.8
 * @Description:作业4第5小题的部门类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    private Manager manager;        //经理
    private GeneralStaff[] staffs;  //员工信息
}