package com.java.wxg.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-19:01
 * @Since:jdk1.8
 * @Description:作业11
 */

/**
 * 使用StringBuilder方法，完成以下练习：
 * 1)用 StringBuilder 来定义一个字符串：“今天是星期一，”。
 * 2)在 1 的基础追加“考试结果出来了，我及格了！” 【append】
 * 3)将“我现在心情很好。”插入在“星期 X”的后面。【insert】
 * 4)最终显示的结果为：今天是星期一，我现在心情很好。考试结果出来了，我及格了！
 */
public class HomeWork11 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("今天是星期一，");
        System.out.println(stringBuilder.append("考试结果出来了，我及格了！"));
        System.out.println(stringBuilder.insert(7, "我现在心情很好。"));
        //System.out.println(stringBuilder.delete(23, 28));//删除“我及格了”
    }
}