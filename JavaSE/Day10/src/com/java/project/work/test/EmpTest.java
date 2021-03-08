package com.java.project.work.test;

import com.java.project.demo.bean.Boss;
import com.java.project.demo.bean.PtEmp;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpTest {
    public static void main(String[] args) {
        Boss boss = new Boss(100,2000,300000);
        boss.salaryCount();

        PtEmp ptEmp = new PtEmp(1000,"实习生");
        ptEmp.salaryCount();
    }
}
