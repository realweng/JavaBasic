package com.java.project.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:08
 * @Since:jdk1.8
 * @Description:TODO
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 需通过控制台接收用户输入的两个整数，然后做除法。
 * 要求用异常处理输入非数字的异常，和除数为0的异常。
 */
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入2个整数");
        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            try {
                System.out.println(num1/num2);
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}