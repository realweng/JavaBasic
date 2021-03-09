package com.java.wxg.test;

import com.java.wxg.action.BikeActionImpl;
import com.java.wxg.action.Impl.BikeAction;
import com.java.wxg.Bike;
import com.java.wxg.BikeCompany;
import com.java.wxg.util.BikeUtil;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:23
 * @Since:jdk1.8
 * @Description:单车的测试
 */
public class BikeTest {
    private BikeAction bikeAction = new BikeActionImpl();   //创建接口实现的对象
    private Scanner scanner= new Scanner(System.in);        //扫描仪

    /**
     * 投放单车
     */
    public void addBikes(BikeCompany[] bikeCompanies) {
        System.out.print("1.ofo单车\n"+"2.哈罗单车\n"+"3.摩拜单车\n");
        System.out.println("请选择要操作的品牌：");
        int select = scanner.nextInt();
        System.out.println("请输入要投放的数量：");
        int num = scanner.nextInt();
        switch (select){
            case 1:
                System.out.println("正在投放：ofo单车");
                bikeAction.addBikes(bikeCompanies[0],num);
                break;
            case 2:
                System.out.println("正在投放：哈罗单车");
                bikeAction.addBikes(bikeCompanies[1],num);
                break;
            case 3:
                System.out.println("正在投放：摩拜单车");
                bikeAction.addBikes(bikeCompanies[2],num);
                break;
            default:
                break;
        }
    }

    /**
     * 删除单车
     */
    public void deleteBikes(BikeCompany[] bikeCompanies) {
        System.out.print("1.ofo单车\n"+"2.哈罗单车\n"+"3.摩拜单车\n");
        System.out.println("请选择要操作的品牌：");
        int select = scanner.nextInt();
        switch (select){
            case 1:
                System.out.println("此ofo单车有共享单车如下");
                showOne(bikeCompanies,select-1);
                System.out.println("请输入要删除车辆的编号：");
                int bid = scanner.nextInt();
                bikeAction.deleteBikes(bikeCompanies[select-1],bid);
                break;
            case 2:
                System.out.println("此哈罗单车有共享单车如下");
                showOne(bikeCompanies,select-1);
                System.out.println("请输入要删除车辆的编号：");
                int bid1 = scanner.nextInt();
                bikeAction.deleteBikes(bikeCompanies[select-1],bid1);
                break;
            case 3:
                System.out.println("此摩拜单车有共享单车如下");
                showOne(bikeCompanies,select-1);
                System.out.println("请输入要删除车辆的编号：");
                int bid2 = scanner.nextInt();
                bikeAction.deleteBikes(bikeCompanies[select-1],bid2);
                break;
            default:
                break;
        }
    }

    /**
     * 只显示某一家公司的单车信息
     */
    public void showOne(BikeCompany[] bikeCompanies,int index){
        Bike bikes[] = bikeCompanies[index].getBikes();
        System.out.println("单车编号"+"\t"+"单车名称"+"\t"+"单车状态"+"\t"+"\t"+"\t"+"借出时间"+"\t"+"\t"+"\t"+"\t"+"\t"+"归还时间"+"\t");
        System.out.println("-------------------------------------------");
        for (Bike bike : bikes) {
            System.out.println(bike.getBid()+"\t"+"\t"+bike.getBname()
                    +"\t"+ BikeUtil.getNameByStatus(bike.getStatus()) +"\t"+bike.getBorrowTime()+"\t"+bike.getReturnTime()+"\t");
            System.out.println("-------------------------------------------");
        }
    }

    /**
     * 查看所有单车
     */
    public void showBikes(BikeCompany[] bikeCompanies) {
        bikeAction.showBikes(bikeCompanies);
    }

    /**
     * 借出单车
     */
    public void lendBike(BikeCompany[] bikeCompanies) {
        System.out.print("1.ofo单车\n"+"2.哈罗单车\n"+"3.摩拜单车\n");
        System.out.println("请选择要借的品牌：");
        int select = scanner.nextInt();
        switch (select){
            case 1:
                lendSelect(bikeCompanies,1);
                break;
            case 2:
                lendSelect(bikeCompanies,2);
                break;
            case 3:
                lendSelect(bikeCompanies,3);
                break;
            default:
                break;
        }
    }

    /**
     * 借出测试流程
     * @param bikeCompanies
     * @param select
     */
    public void lendSelect(BikeCompany[] bikeCompanies,int select){
        showOne(bikeCompanies,select-1);
        System.out.println("请输入要借出单车的编号：");
        int bid = scanner.nextInt();
        bikeAction.lendBike(bikeCompanies[select-1],bid);
    }

    /**
     * 归还单车
     */
    public void returnBike(BikeCompany[] bikeCompanies) throws ParseException {
        System.out.print("1.ofo单车\n"+"2.哈罗单车\n"+"3.摩拜单车\n");
        System.out.println("请选择归还的品牌：");
        int select = scanner.nextInt();
        switch (select){
            case 1:
                returnSelect(bikeCompanies,1);
                break;
            case 2:
                returnSelect(bikeCompanies,2);
                break;
            case 3:
                returnSelect(bikeCompanies,3);
                break;
            default:
                break;
        }
    }

    /**
     * 归还测试流程
     * @param bikeCompanies
     * @param select
     * @throws ParseException
     */
    public void returnSelect(BikeCompany[] bikeCompanies,int select) throws ParseException {
        showOne(bikeCompanies,select-1);
        System.out.println("请输入要归还车辆的编号！");
        int bid = scanner.nextInt();
        bikeAction.returnBike(bikeCompanies[select-1],bid);
    }

    public void rankBike(BikeCompany[] bikeCompanies){
        bikeAction.rankBike(bikeCompanies);
    }
}