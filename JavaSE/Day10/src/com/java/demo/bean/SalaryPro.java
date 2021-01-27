package com.java.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-15:10
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SalaryPro extends Salary{

    @Override
    public void calSalary1() {
        System.out.println("工资1："+getBaseSalary());
    }

    @Override
    public void calSalary2() {
        System.out.println("工资2："+(getBaseSalary()+getBaseSalary()*getProSalary()));
    }

    @Override
    public void calSalary3() {
        System.out.println("工资3："+(getBaseSalary()+getBaseSalary()*getProSalary()+getBonus()));
    }

    public SalaryPro(int baseSalary, int proSalary, int bonus) {
        super(baseSalary, proSalary, bonus);
    }
}