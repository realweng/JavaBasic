package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-18:38
 * @Since:jdk1.8
 * @Description:作业2
 */

import com.java.homework.demo.PM;
import com.java.homework.demo.SE;
import com.java.homework.demo.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * 建好员工基类和程序员、项目经理子类的基础上，创建一个测试类。
 * 创建一个ArrayList集合对象，要求保存两个程序员和两个项目经理的对象，
 * 并循环调用show的方法显示详细信息
 */
public class HomeWork2 {
    private List<Staff> staffs = new ArrayList<>(4);

    /**
     * 构造器 初始化
     */
    public HomeWork2() {
        PM pm1 = new PM("1001","张三",10000,1000);
        PM pm2 = new PM("1002","李四",15000,800);
        SE se1 = new SE("2001","王二",9000,1);
        SE se2 = new SE("2002","赵明",10000,2);
        staffs.add(pm1);
        staffs.add(se1);
        staffs.add(pm2);
        staffs.add(se2);
    }

    public void show(){
        System.out.println("------------------------------");
        for (int i = 0; i < staffs.size(); i++) {
            if(staffs.get(i) instanceof PM){
                PM pm = (PM)staffs.get(i);
                System.out.println("id："+pm.getId()+"\t姓名："+pm.getName()+"\t基本工资："+pm.getBaseSalary()+"\t奖金："+pm.getBonus());
                System.out.println("------------------------------");

            }else if(staffs.get(i) instanceof SE){
                SE se = (SE)staffs.get(i);
                System.out.println("id："+se.getId()+"\t姓名："+se.getName()+"\t基本工资："+se.getBaseSalary()+"\t经验："+se.getExp());
                System.out.println("------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        new HomeWork2().show();
    }
}