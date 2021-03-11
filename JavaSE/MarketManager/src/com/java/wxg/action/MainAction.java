package com.java.wxg.action;

import com.java.wxg.constants.MarketConstants;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-16:28
 * @Since:jdk1.8
 * @Description:主界面（菜单）
 */
public class MainAction {
    private Scanner scanner;

    /**
     * 构造方法，初始化数据
     */
    public MainAction() {
        scanner = new Scanner(System.in);
    }

    /**
     * 主菜单显示
     */
    public void mainMenu() {
        System.out.println("*****************************欢迎来到超市管理系统*****************************");
        System.out.println("1、商品类型管理");
        System.out.println("2、商品管理");
        System.out.println("3、会员管理");
        System.out.println("4、购买管理");
        System.out.println("5、订单管理");
        System.out.println("6、排行统计管理");
        System.out.println("请选择：");
        int select = scanner.nextInt();
        //登录
        login(select);
    }

    public void login(int select) {
        System.out.println("操作请先登录>>>");
        System.out.println("请输入账号：");
        String inputName = scanner.next();
        System.out.println("请输入密码：");
        String inputPwd = scanner.next();

        //判断
        if (inputName.equals(MarketConstants.MANAGER_ACCOUNT) && inputPwd.equals(MarketConstants.MANAGER_PASSWORD)) {
            System.out.println("管理员登录成功！");
            if (select > 3 && select <= 6) {
                System.out.println("没有收银员权限");
                mainMenu();
                return;//执行结束直接退出,保证不会越权访问收银员才能操作的数据
            }
            adminSelect(select);
        } else if (inputName.equals(MarketConstants.CASHIER_ACCOUNT) && inputPwd.equals(MarketConstants.CASHIER_PASSWORD)) {
            System.out.println("收银员登录成功");
            if (select <= 3 && select > 0) {
                System.out.println("没有管理员权限");
                mainMenu();
                return;//执行结束直接退出,保证不会越权访问管理员才能操作的数据
            }
            cashierSelect(select);
        } else {
            System.out.println("用户名或者密码输入错误");
            //返回主菜单
            mainMenu();
        }
    }

    /**
     * 只有管理员能选择执行的操作
     *
     * @param select
     */
    public void adminSelect(int select) {
        switch (select) {
            case 1:
                //商品类型管理的菜单
                new ProductTypeAction(scanner).typeMenu();
                break;
            case 2:
                //商品管理的菜单
                new ProductAction(scanner).productMenu();
                break;
            case 3:
                //会员管理的菜单
                new VIPAction(scanner).vipMenu();
                break;
            case 0:
                System.out.println("退出中...");
                return;
            default:
                System.out.println("选择错误，返回主菜单！");
                mainMenu();
        }
        adminMenu();
    }

    /**
     * 管理员操作菜单
     */
    public void adminMenu() {
        System.out.println("*****************************管理员操作台*****************************");
        System.out.println("1、商品类型管理");
        System.out.println("2、商品管理");
        System.out.println("3、会员管理");
        System.out.println("0、退出系统");
        System.out.println("请输入要进行的操作：");
        adminSelect(scanner.nextInt());
    }

    /**
     * 收银员操作
     *
     * @param select
     */
    public void cashierSelect(int select) {
            switch (select) {
                case 4:
                    //购买管理
                    new PurchaseManagerAction(scanner).purchaseMenu();
                    break;
                case 5:
                    //订单管理
                    new OrderQueryAction(scanner).orderQueryMenu();
                    break;
                case 6:
                    //排行管理
                    new RankStatisticsAction(scanner).rankStatisticsMenu();
                    break;
                case 0:
                    System.out.println("退出中...");
                    return;
                default:
                    System.out.println("选择错误，返回主菜单！");
                    cashierMenu();
            }
            cashierMenu();
    }

    /**
     * 收银员操作菜单显示
     */
    public void cashierMenu() {
        System.out.println("*****************************收银员操作台*****************************");
        System.out.println("4、购买管理");
        System.out.println("5、订单管理");
        System.out.println("6、排行统计管理");
        System.out.println("0、退出系统");
        System.out.println("请选择：");
        cashierSelect(scanner.nextInt());
    }

}