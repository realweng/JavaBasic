package com.java.wxg.action;

import com.java.wxg.bean.Emp;
import com.java.wxg.bean.vo.ClockInVO;
import com.java.wxg.service.ClockInService;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-16:22
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClockInAction {
    ClockInService clockInService = new ClockInService();
    Scanner scanner = new Scanner(System.in);

    /**
     * 通过emp的id查找对应员工的打卡记录
     *
     * @param emp
     */
    public void findClockInByEmpId(Emp emp) {
        if (emp != null) {
            List<ClockInVO> clockInByEmpId = clockInService.findClockInByEmpId(emp.getEmpId());
            System.out.println("编号\t姓名\t\t性别\t\t打卡时间\t\t打卡是否成功");
            for (ClockInVO clockInVO : clockInByEmpId) {
                if (clockInVO.getClockFlag() == 1) {
                    System.out.println(clockInVO.getEmpId() + "\t" + clockInVO.getEmpName() + "\t\t" + clockInVO.getEmpGender() + "\t\t" + clockInVO.getClockTime() + "\t\t" + "迟到");
                } else {
                    System.out.println(clockInVO.getEmpId() + "\t" + clockInVO.getEmpName() + "\t\t" + clockInVO.getEmpGender() + "\t\t" + clockInVO.getClockTime() + "\t\t" + "正常");
                }
            }
        }
    }

    public void clockIn(Emp emp) {
        int i = clockInService.clickIn(emp);
        if (i > 0) {
            System.out.println("打卡成功！");
        } else {
            System.out.println("打卡失败");
        }
    }

    /**
     * 登录成功后的菜单
     *
     * @param emp
     */
    public void clockInMenu(Emp emp) {
        boolean flag = true;
        while (flag){
            System.out.println("1、上班打卡");
            System.out.println("2、修改自己的个人信息");
            System.out.println("3、显示自己的打卡记录");
            System.out.println("0、返回上一级");
            System.out.println("请输入你的选择：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    clockIn(emp);
                    break;
                case 2:
                    new EmpAction().updateInfo(emp);
                    break;
                case 3:
                    findClockInByEmpId(emp);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}