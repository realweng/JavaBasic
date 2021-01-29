package com.java.test;

import com.java.bean.*;
import com.java.constant.ConstantUtil;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:23
 * @Since:jdk1.8
 * @Description:程序启动入口,初始化信息
 */
public class Start {
    private BikeCompany[] companies; //单车公司
    private Scanner scanner;         //扫描仪
    private BikeTest bikeTest;


    /**
     * 构造器 数据初始化
     */
    public Start() {
        bikeTest = new BikeTest();
        companies = new BikeCompany[3];
        scanner = new Scanner(System.in);
        init();
    }

    /**
     * 处理数据，进行数据的初始化
     */
    public void init() {
        //ofo公司及其单车初始化
        companies[0] = new BikeCompany(1, ConstantUtil.OFO_COMPANY, null, 4, 0);
        OfoBike ofoBikes[] = new OfoBike[companies[0].getSum()];
        for (int i = 0; i < ofoBikes.length; i++) {
            ofoBikes[i] = new OfoBike((i + 101), (ConstantUtil.OFO_COMPANY + (i + 101)), 1, null,null);
        }
        companies[0].setBikes(ofoBikes);

        //哈罗公司及其单车初始化
        companies[1] = new BikeCompany(2, ConstantUtil.HELLO_COMPANY, null, 5, 0);
        HelloBike helloBikes[] = new HelloBike[companies[1].getSum()];
        for (int i = 0; i < helloBikes.length; i++) {
            helloBikes[i] = new HelloBike((i + 201), (ConstantUtil.HELLO_COMPANY + (i + 201)), 1, null,null);
        }
        companies[1].setBikes(helloBikes);

        //摩拜公司及其单车初始化
        companies[2] = new BikeCompany(3, ConstantUtil.MO_COMPANY, null, 3, 0);
        MoBike moBikes[] = new MoBike[companies[2].getSum()];
        for (int i = 0; i < moBikes.length; i++) {
            moBikes[i] = new MoBike((i + 301), (ConstantUtil.MO_COMPANY + (i + 301)), 1, null,null);
        }
        companies[2].setBikes(moBikes);
    }

    /**
     * 开始菜单
     */
    public void startMenu() throws ParseException {
        System.out.println("欢迎使用迷你共享单车管理系统");
        System.out.println("*************************");
        System.out.println("1.查看单车");
        System.out.println("2.投放单车");
        System.out.println("3.删除单车");
        System.out.println("4.借出单车");
        System.out.println("5.归还单车");
        System.out.println("6.借出排行");
        System.out.println("7.退出系统");
        System.out.println("*************************");
        System.out.println("请输入你要进行的操作");
        int select = scanner.nextInt();
        switch(select){
            case 1:
                System.out.println("---->1.查看单车");
                bikeTest.showBikes(companies);
                break;
            case 2:
                System.out.println("---->2.投放单车");
                bikeTest.addBikes(companies);
                break;
            case 3:
                System.out.println("---->3.删除单车");
                bikeTest.deleteBikes(companies);
                break;
            case 4:
                System.out.println("---->4.借出单车");
                bikeTest.lendBike(companies);
                break;
            case 5:
                System.out.println("---->5.归还单车");
                bikeTest.returnBike(companies);
                break;
            case 6:
                System.out.println("---->6.借出排行");
                bikeTest.rankBike(companies);
                break;
            case 7:
                System.out.println("---->感谢使用");
                return;
        }
        returnMenu();
    }

    /**
     *结束菜单的方法
     */
    public void returnMenu() throws ParseException {
        System.out.println("请输入0返回");
        int select = scanner.nextInt();
        if(select != 0){
            System.out.println("感谢使用");
            return;
        }
        startMenu();
    }
    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {
       new Start().startMenu();
    }
}