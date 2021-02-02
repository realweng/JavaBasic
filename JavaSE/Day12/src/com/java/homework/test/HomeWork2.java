package com.java.homework.test;

import com.java.homework.bean.Store;
import com.java.homework.bean.StoreException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:16
 * @Since:jdk1.8
 * @Description:作业2 测试类
 */

/**
 * 模拟实现用户购买商品的功能，使用数组模拟商品列表，
 * 当购买的商品不存在或者商品库存为0时，抛出自定义异常。
 * 用户购买某一个商品时，对异常进行处理，并对库存进行改变。
 */
public class HomeWork2 {
    static private Store[] goods; //商品数组
    static private Scanner scanner;//扫描仪

    /**
     * 构造器 初始化
     */
    public HomeWork2() {
        //数据初始化
        //init();
        scanner = new Scanner(System.in);
    }

    public void init(){
        goods = new Store[3];
        goods[0] = new Store("001",10);
        goods[1] = new Store("002",0);
        goods[2] = new Store("003",3);
    }

    /**
     * 用户购买商品的方法
     */
    public void buy(Store[] goods) throws StoreException {
        System.out.println("商品id\t商品库存");
        for (Store good : goods) {
            System.out.println(good.getId()+"\t"+"\t"+"\t"+good.getNum());
        }
        System.out.println("请输入需要购买的商品编号");
        String id = scanner.next();
        boolean haveGoods = false;
        int temp = 0,index = 0;
        for (int i = 0; i < goods.length; i++) {
            if(goods[i].getId().equals(id)){
                haveGoods = true;
                temp = goods[i].getNum();
                index = i;
            }
        }
        if(haveGoods){
            if(temp == 0){
                throw new StoreException("商品库存不足！");
            }else {
                System.out.println("购买成功！");
                //库存-1
                goods[index].setNum(goods[index].getNum()-1);
            }
        }else {
            throw new StoreException("不存在该商品！");
        }
        System.out.println("商品id\t商品库存");
        for (Store good : goods) {
            System.out.println(good.getId()+"\t"+"\t"+"\t"+good.getNum());
        }
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        HomeWork2 homeWork2 = new HomeWork2();
        try {
            homeWork2.init();
            boolean isFlag = true;
            while (isFlag){
                new HomeWork2().buy(goods);
                System.out.println("是否退出 y/n");
                String str = scanner.next();
                if(str.equals("y")){
                    isFlag = false;
                }
            }
        } catch (StoreException e) {
            System.out.println(e.getMessage());
        }
    }
}