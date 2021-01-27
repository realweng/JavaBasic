package com.java.homework.test;

import com.java.homework.bean.ManageStuimpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:29
 * @Since:jdk1.8
 * @Description:作业3 测试类
 */
public class StudentTest {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        ManageStuimpl manageStuimpl = new ManageStuimpl(); //创建实现类的一个对象
        manageStuimpl.showAll();//展示所有学生的成绩
        manageStuimpl.calGrade("张三"); //计算张三及格的科目数与总成绩
        manageStuimpl.showGrade("李四");//显示李四的所有信息
        manageStuimpl.showGrade("李二");//没有查找到的姓名会提示没有该学生
    }
}