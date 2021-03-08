package com.java.project.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:37
 * @Since:jdk1.8
 * @Description:计算器类
 */

/**
 * 描述一个计算器类 , 计算机有 操作数1 ， 操作数2 ，
 * 运算符 三个属性，还具备运算的功能。
 * 要求：不能直接给 操作数1 操作数2，运算符直接赋值
 */
public class Calculator {
    private double num1; //操作数1
    private double num2; //操作数2
    public String symbol;//运算符

    /**
     * 计算功能
     */
    public double calculate(){
        if(symbol.equals("+")){
            return num1+num2;
        }else if(symbol.equals("-")){
            return num1-num2;
        }else if(symbol.equals("*")){
            return num1*num2;
        }else if (symbol.equals("/")){
            return num1/num2;
        }else
            System.out.println("计算符输入错误");
        return 0;
    }

    /**
     * 有参构造
     * @param symbol 运算符
     */
    public Calculator(String symbol) {
        this.symbol = symbol;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}