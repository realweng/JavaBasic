package com.java.wxg.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-15:08
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Salary {
    private int baseSalary;
    private int proSalary;
    private int bonus;

    public abstract void calSalary1();
    public abstract void calSalary2();
    public abstract void calSalary3();
}