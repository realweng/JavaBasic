package com.java.project.homework.test;

import com.java.project.homework.demo.Calculator;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-20:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("*");
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.calculate());
    }
}