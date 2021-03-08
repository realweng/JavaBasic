package com.java.project.project.action;

import com.java.project.project.bean.Dept;
import com.java.project.project.bean.Emp;
import com.java.project.project.service.DeptService;
import com.java.project.project.service.EmpService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-11:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpAction {
    private Scanner scanner = new Scanner(System.in);
    private EmpService empService = new EmpService();
    private DeptService deptService = new DeptService();

    /**
     * 登录菜单列表
     */
    public void loginMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("***************欢迎使用XX公司打卡系统*****************");
            System.out.println("1、登录。");
            System.out.println("2、注册。");
            System.out.println("0、退出。");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("您选择>>登录");
                    Emp emp = login();
                    if (emp != null) {
                        new ClockInAction().clockInMenu(emp);
                    }
                    break;
                case 2:
                    System.out.println("您选择>>注册");
                    register();
                    break;
                case 0:
                    System.out.println("退出中...");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 员工登录
     */
    private Emp login() {
        System.out.println("请输入账号：");
        Integer empId = scanner.nextInt();
        System.out.println("请输入密码：");
        String empPwd = scanner.next();
        Emp emp = empService.login(empId, empPwd);
        //判断
        if (emp != null) {
            System.out.println("登录成功！" + emp.getEmpName() + "  " + emp.getDept().getDepId());
        } else {
            System.out.println("登录失败！");
        }
        return emp;
    }

    private void register() {
        Emp emp = new Emp();
        System.out.println("开始注册----");
        System.out.println("请输入要注册的用户名：");
        emp.setEmpUname(scanner.next());
        System.out.println("请输入密码：");
        emp.setEmpPwd(scanner.next());
        System.out.println("请输入姓名：");
        emp.setEmpName(scanner.next());
        System.out.println("请输入性别：");
        emp.setEmpGender(scanner.next());
        System.out.println("请选择部门：");
        List<Dept> list = deptService.showAllDept();
        for (Dept dept : list) {
            System.out.println("编号：" + dept.getDepId() + "\t部门：" + dept.getDepName());
        }
        int select = scanner.nextInt();
        for (Dept dept : list) {
            if (dept.getDepId() == select) {
                emp.setDept(dept);
                break;
            }
        }
        emp.setEmpDate(new Date());
        int register = empService.register(emp);
        if (register > 0) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }

    /**
     * 修改用户信息
     *
     * @param emp
     */
    public void updateInfo(Emp emp) {
        if (emp != null) {
            System.out.println("请输入要修改的用户名：");
            emp.setEmpUname(scanner.next());
            System.out.println("请输入要修改的密码：");
            emp.setEmpPwd(scanner.next());
            System.out.println("请输入要修改的姓名：");
            emp.setEmpName(scanner.next());
            System.out.println("请输入要修改的性别：");
            emp.setEmpGender(scanner.next());
            System.out.println("请请选择要修改的部门：");
            List<Dept> list = deptService.showAllDept();
            for (Dept dept : list) {
                System.out.println("编号：" + dept.getDepId() + "\t部门：" + dept.getDepName());
            }
            int select = scanner.nextInt();
            for (Dept dept : list) {
                if (dept.getDepId() == select) {
                    emp.setDept(dept);
                    break;
                }
            }
            empService.updateInfo(emp);
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }
}