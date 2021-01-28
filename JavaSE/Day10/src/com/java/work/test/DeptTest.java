package com.java.work.test;

import com.java.demo.bean.Boss;
import com.java.demo.bean.Dept;
import com.java.demo.bean.PtEmp;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:21
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DeptTest {
    //部门
    private Dept dept;
    private Scanner scanner;

    public DeptTest() {
        init();
    }

    /**
     * 初始化
     */
    public void init() {
        //初始化数据
        dept.setDeptName("研发部");
        //经理
        Boss boss = new Boss(1001, "张三", 1000, 2000, 3000);
        //将经理设置到部门
        dept.setBoss(boss);
        //准备一个数组，用来装员工
        PtEmp[] ptEmp = new PtEmp[3];
        ptEmp[0] = new PtEmp(1, "tom", 3000, "实习生");
        ptEmp[1] = new PtEmp(2, "cat", 2000, "实习生");
        ptEmp[2] = new PtEmp(3, "lucy", 1000, "实习生");
        //将数组存放到部门
        dept.setPtEmps(ptEmp);
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        // new DeptTest().start();
    }
}
