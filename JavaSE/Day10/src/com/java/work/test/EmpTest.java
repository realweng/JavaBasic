package com.java.work.test;

import com.java.work.bean.Boss;
import com.java.work.bean.PtEmp;

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
