package com.java.project.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-20:08
 * @Since:jdk1.8
 * @Description:TODO
 */

import com.java.project.homework.action.EmpAction;
import com.java.project.homework.action.impl.EmpActionImpl;
import com.java.project.homework.demo.Emp;

import java.io.File;
import java.util.List;

/**
 * 2、实现一个随机点名的功能。
 * (1)在文件中存储所有的学生名字。
 * (2)然后将数据读取存储到集合中。
 * (3)然后再通过这个集合产生一个随机数。
 * (4)再取值！
 */
public class HomeWork2 {
    public static void main(String[] args) {
        EmpAction empAction = new EmpActionImpl();
        File file = new File("emp.txt");//去第一题里的文件及员工姓名
        List<Emp> allEmp = empAction.findAllEmp();
        while (allEmp.size()>0){//随机点名
            int random = (int) (Math.random()*allEmp.size());//产生0到size()-1的随机数
            Emp emp = allEmp.remove(random);//存储被移除的信息
            System.out.println("姓名："+emp.getName());
        }
    }
}