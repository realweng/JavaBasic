package com.java.wxg.action;

import com.java.wxg.bean.ProductType;
import com.java.wxg.bean.vo.RankVO;
import com.java.wxg.service.RankStatisticsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-23:34
 * @Since:jdk1.8
 * @Description:排行统计的表示层
 */
public class RankStatisticsAction {
    private Scanner scanner;//扫描仪
    private RankStatisticsService rankStatisticsService;//排行统计业务实现的对象
    private List<RankVO> rankList;

    public RankStatisticsAction(Scanner scanner) {
        this.scanner = scanner;
        rankStatisticsService = new RankStatisticsService();
        rankList = new ArrayList<>(10);
    }

    /**
     * 排行统计菜单
     */
    public void rankStatisticsMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("1.按月份统计商品销量排行");
            System.out.println("2.按商品类型统计商品销量排行");
            System.out.println("0.退出当前菜单");
            System.out.println("请选择：");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("您选择按月份统计商品销量排行-->");
                    rankByMonth();
                    break;
                case 2:
                    System.out.println("您选择按商品类型统计商品销量排行-->");
                    rankByProductType();
                    break;
                case 0:
                    System.out.println("退出中...");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 按照月份排行
     */
    public void rankByMonth() {
        System.out.println("请输入您要查询的月份：");
        int month = scanner.nextInt();
        if (month <= 0 || month > 12) {
            System.out.println("月份输入非法！");
            return;
        }
        //执行查询
        rankList = rankStatisticsService.rankByMonth(month);
        System.out.println("----------------------------------------------------------------------------------------------");
        for (RankVO rank : rankList) {
            System.out.println(rank.toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    /**
     * 按照商品类型排行
     */
    public void rankByProductType() {
        List<ProductType> typeInOrder = rankStatisticsService.findTypeInOrder();
        if (typeInOrder.size() > 0) {
            System.out.println("订单中已有的商品类型及其对应的id如下：");
            System.out.println("-----------------------------------------------");
            System.out.println("编号\t商品类型");
            for (ProductType productType : typeInOrder) {
                System.out.println(productType.getId() + "\t" + productType.getTypeName());
            }
            System.out.println("-----------------------------------------------");
            System.out.println("请选择类型编号：");
            int typeId = scanner.nextInt();
            int index = -1;//索引
            for (int i = 0; i < typeInOrder.size(); i++) {
                if (typeId == typeInOrder.get(i).getId()) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("选择错误，订单列表中暂不存在该商品类型！");
                return;
            } else {
                //执行查询
                rankList = rankStatisticsService.rankByProductType(typeId);
                System.out.println("------------------------------------------------------------------------------------------");
                for (RankVO rank : rankList) {
                    System.out.println(rank.toString());
                }
                System.out.println("------------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("暂无订单信息！");
            return;
        }
    }
}