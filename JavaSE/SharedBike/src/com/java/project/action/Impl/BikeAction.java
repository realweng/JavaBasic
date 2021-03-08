package com.java.project.action.Impl;

import com.java.project.demo.bean.BikeCompany;

import java.text.ParseException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:25
 * @Since:jdk1.8
 * @Description:共享单车系统的接口
 */
public interface BikeAction {
    /**
     * 投放单车 哪个公司，投放几辆
     */
    public void addBikes(BikeCompany bikeCompany,int num);

    /**
     * 删除单车 bid表示单车的编号
     */
    public void deleteBikes(BikeCompany bikeCompany,int bid);

    /**
     * 查看所有单车
     */
    public void showBikes(BikeCompany[] bikeCompanies);

    /**
     * 借出单车
     * @param bid 编号
     */
    public void lendBike(BikeCompany bikeCompany,int bid);

    /**
     * 归还单车
     * @param bid 编号
     */
    public void returnBike(BikeCompany bikeCompany,int bid) throws ParseException;

    /**
     * 借出排行榜
     * @param bikeCompanies
     */
    public void rankBike(BikeCompany[] bikeCompanies);
}
