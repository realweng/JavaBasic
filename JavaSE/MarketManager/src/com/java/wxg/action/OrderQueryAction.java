package com.java.wxg.action;

import com.java.wxg.bean.vo.OrderQueryVO;
import com.java.wxg.service.OrderQueryService;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-22:05
 * @Since:jdk1.8
 * @Description:订单查询表示层
 */
public class OrderQueryAction {
    private Scanner scanner;//扫描仪
    private OrderQueryService orderQueryService;//订单查询处理的对象

    /**
     * 构造器 初始化数据
     *
     * @param scanner
     */
    public OrderQueryAction(Scanner scanner) {
        this.scanner = scanner;
        orderQueryService = new OrderQueryService();
    }

    /**
     * 订单查询菜单
     */
    public void orderQueryMenu() {
        boolean flag = true;
        while (flag){
            System.out.println("1.通过商品编号查询订单记录");
            System.out.println("2.通过会员编号查询订单记录");
            System.out.println("0.退出当前菜单");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("您选择输入商品编号查询订单记录-->");
                    queryOrderByProductId();
                    break;
                case 2:
                    System.out.println("您选择输入会员编号查询订单记录-->");
                    queryOrderByVipId();
                    break;
                case 0:
                    System.out.println("退出中...");
                    flag = false;
                    break;
                default:
                    System.out.println("选择错误");
                    break;
            }
        }
    }

    /**
     * 通过商品编号查询订单记录
     */
    public void queryOrderByProductId(){
        System.out.println("请输入商品编号：");
        int productId = scanner.nextInt();
        List<OrderQueryVO> list = orderQueryService.queryByProductId(productId);
        if(list.size()!=0){
            System.out.println("--------------------------------------------------------------------------------");
            for (OrderQueryVO orderQueryVO : list) {
                System.out.println(orderQueryVO.toString());
            }
            System.out.println("--------------------------------------------------------------------------------");
        }else {
            System.out.println("暂无该条件的记录！");
        }
    }

    public void queryOrderByVipId(){
        System.out.println("请输入会员编号：");
        int vipId = scanner.nextInt();
        List<OrderQueryVO> list = orderQueryService.queryByVipId(vipId);
        if(list.size()!=0){
            System.out.println("--------------------------------------------------------------------------------");
            for (OrderQueryVO orderQueryVO : list) {
                System.out.println(orderQueryVO.toString());
            }
            System.out.println("--------------------------------------------------------------------------------");
        }else {
            System.out.println("暂无该条件的记录！");
        }
    }
}