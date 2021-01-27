package com.java.demo.test;

import com.java.demo.bean.Salary;
import com.java.demo.bean.SalaryPro;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-15:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SalaryTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Salary salary1 = new SalaryPro(10000,1,1010);
        salary1.calSalary1();
        salary1.calSalary2();
        salary1.calSalary3();
    }
}