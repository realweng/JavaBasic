package com.java.homework.inter;

import com.java.homework.demo.Grade;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:20
 * @Since:jdk1.8
 * @Description:作业3 学生成绩管理的接口
 */
public interface ManageStudent {
    /**
     * 根据某个学生的名称，查找对应的成绩
     * @param name 学生姓名当做参数
     */
    public Grade[] showGrade(String name);

    /**
     * 根据某个学生的名称，计算及格的成绩有几门
     * 并且计算出该学生的总分数
     * @param name
     */
    public void calGrade(String name);

    /**
     * 显示所有学生的成绩
     */
    public void showAll();
}
