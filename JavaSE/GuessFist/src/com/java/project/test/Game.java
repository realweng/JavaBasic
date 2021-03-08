package com.java.project.test;

import com.java.project.project.Computer;
import com.java.project.project.User;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/30-13:44
 * @Since:jdk1.8
 * @Description:游戏类
 */
public class Game {
    User user = new User();
    Computer computer = new Computer();
    Scanner scanner = new Scanner(System.in);
    int comSelect; //记录电脑出拳的结果
    /**
     *     初始化方法
     */
    public void initial(){
        System.out.println("\t\t\t\t\t\t*****************");
        System.out.println("\t\t\t\t\t\t*****************");
        System.out.println("\t\t\t\t\t\t**  猜拳，开始  **");
        System.out.println("出拳规则1.剪刀 2.石头 3.布");
        System.out.println("请选择对方角色（1.刘备 2.孙权 3.曹操）：");
        int whatComputer = scanner.nextInt();
        computer.selectCpt(whatComputer); //选择对战角色
    }

    /**
     * 开始游戏的方法startGame
     */
    public void startGame(){
        initial();
        showFist();
    }

    public void showFist(){
        System.out.println("要开始吗？（y/n）");
        String confirm = scanner.next();
        if(confirm.equals("y")){
            System.out.println("请出拳：1.剪刀 2.石头 3.布（请输入相应的数字）：");
            int select = scanner.nextInt();
            user.guessWhat(select);
            System.out.println(computer.name+"出拳");
            comSelect = computer.guessWhat();
            if(select == comSelect){
                System.out.println("和局，真衰！");
            }else if(select == 1 && comSelect == 2){
                System.out.println(computer.name+"赢了");
            }else if(select == 1 && comSelect == 3){
                System.out.println("你赢了");
            }else if(select == 2 && comSelect == 1){
                System.out.println("你赢了");
            }else if(select == 2 && comSelect == 3){
                System.out.println(user.computer.name+"赢了");
            }else if(select == 3 && comSelect == 1){
                System.out.println(computer.name+"赢了");
            }else if(select == 3 && comSelect == 2){
                System.out.println("你赢了");
            }
        }
    }
}