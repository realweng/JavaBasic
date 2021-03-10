package com.java.wxg.action;

import com.java.wxg.bean.VIP;
import com.java.wxg.service.VIPService;
import com.java.wxg.util.MD5Util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-9:42
 * @Since:jdk1.8
 * @Description:会员管理菜单
 */
public class VIPAction {
    private Scanner scanner;//扫描仪
    private VIPService vipService;//会员业务处理层对象
    private VIP vip;//会员对象

    /**
     * 构造器 初始化信息
     *
     * @param scanner
     */
    public VIPAction(Scanner scanner) {
        this.scanner = scanner;
        vipService = new VIPService();
        vip = new VIP();
    }

    /**
     * 会员信息管理菜单
     */
    public void vipMenu() {
        System.out.println("1、添加会员信息");
        System.out.println("2、修改会员信息");
        System.out.println("3、查询会员信息");
        System.out.println("4、删除会员信息");
        System.out.println("5、会员余额充值");
        System.out.println("请选择：");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("您选择添加会员信息-->");
                addVIP();
                break;
            case 2:
                System.out.println("您选择修改会员信息-->");
                updateVIP();
                break;
            case 3:
                System.out.println("您选择查询会员信息-->");
                queryVIP();
                break;
            case 4:
                System.out.println("您选择删除会员信息-->");
                deleteVIP();
                break;
            case 5:
                System.out.println("您选择会员余额充值-->");
                recharge();
                break;
            default:
                break;
        }
    }

    /**
     * 添加会员信息
     */
    public void addVIP() {
        System.out.println("正在生成会员卡卡号");
        //利用数据库中最后一个编号生成下一个会员卡卡号，这样会员卡卡号就不会重复
        Integer lastVipId = vipService.findLastVipId();
        Integer vipId = lastVipId + 1001;
        System.out.println("生成的会员卡号为：" + vipId);
        vip.setCardNumber(vipId.toString());
        System.out.println("请输入会员密码：");
        String pwd = scanner.next();
        pwd = MD5Util.encryption(pwd);
        vip.setVipPassword(pwd);
        System.out.println("请输入会员姓名：");
        vip.setVipName(scanner.next());
        System.out.println("请输入会员电话");
        vip.setIphone(scanner.next());
        //会员积分默认为0
        vip.setJiFen(0);
        //会员默认初始余额为100
        vip.setMoney(100.0);
        //生成办卡时间
        vip.setCreateTime(new Date());
        //执行添加操作
        int i = vipService.addVIP(vip);
        if (i>0) {
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    /**
     * 修改会员信息
     */
    public void updateVIP() {
        System.out.println("请输入要修改会员的id");
        int id = scanner.nextInt();
        //通过id找要修改的会员
        vip = vipService.findVipById(id);
        if(vip.getId()!=null){
            System.out.println(vip.toString());
            System.out.println("是否修改密码：(y/n)");
            if(scanner.next().equals("y")){
                System.out.println("请输入修改后的密码：");
                String pwd = scanner.next();
                pwd = MD5Util.encryption(pwd);
                vip.setVipPassword(pwd);
            }
            System.out.println("是否修改姓名：(y/n)");
            if(scanner.next().equals("y")){
                System.out.println("请输入修改后的姓名：");
                vip.setVipName(scanner.next());
            }
            System.out.println("是否修改电话：(y/n)");
            if(scanner.next().equals("y")){
                System.out.println("请输入修改后的电话：");
                vip.setIphone(scanner.next());
            }
            System.out.println("是否修改积分：(y/n)");
            if(scanner.next().equals("y")){
                System.out.println("请输入修改后的积分：");
                vip.setJiFen(scanner.nextInt());
            }
            vip.setUpdateTime(new Date());
            //执行修改操作
            int i = vipService.updateVIP(vip);
            if(i>0){
                System.out.println("修改成功！");
            }else {
                System.out.println("修改失败！");
            }
        }else {
            System.out.println("id不存在，修改失败！");
        }
    }

    /**
     * 查询会员信息
     */
    public void queryVIP() {
        List<VIP> list = vipService.queryVIP();
        System.out.println("会员编号\t会员卡号\t\t会员姓名\t\t\t会员电话\t\t\t会员余额\t\t创建时间\t\t\t\t更新时间");
        for (VIP v : list) {
            System.out.println(v.getId()+"\t"+v.getCardNumber()+"\t\t"+v.getVipName()+"\t\t\t"+
                    v.getIphone()+"\t\t\t"+v.getMoney()+"\t\t"+v.getCreateTime()+"\t\t\t\t"+v.getUpdateTime());
        }
    }

    /**
     * 删除会员信息
     */
    public void deleteVIP() {
        System.out.println("请输入要删除会员对应的编号：");
        int id = scanner.nextInt();
        int i = vipService.deleteVIP(id);
        if(i>0){
            System.out.println("删除成功！");
        }else {
            System.out.println("编号不存在，删除失败！");
        }
    }

    /**
     * 会员余额充值
     */
    public void recharge() {
        System.out.println("请输入要充值会员的编号：");
        int id = scanner.nextInt();
        vip = vipService.findVipById(id);
        if(vip.getId()!=null){
            System.out.println("请输入要充值的金额：");
            double money = scanner.nextDouble();
            int i = vipService.recharge(id, money);
            if(i > 0){
                System.out.println("充值成功！");
            }else {
                System.out.println("充值失败！");
            }
        }else {
            System.out.println("不存在该会员编号，操作失败！");
        }
    }
}