package com.java.homework.test;

import com.java.homework.dao.StudentDAO;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-18:59
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    private StudentDAO studentDAO = new StudentDAO();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("1.添加 2.删除 3.修改 4.查询所有 5.根据专业查询 0.退出");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }
}