package com.java.action;

import com.java.action.Impl.BikeAction;
import com.java.bean.*;
import com.java.constant.ConstantUtil;
import com.java.util.BikeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:24
 * @Since:jdk1.8
 * @Description:接口的实现
 */
public class BikeActionImpl implements BikeAction {
    /**
     * 投放单车
     * @param bikeCompany 哪家公司投放
     * @param num 投放几辆
     */
    @Override
    public void addBikes(BikeCompany bikeCompany,int num) {
        if(bikeCompany != null){
            Bike bikes[] = bikeCompany.getBikes();
            for (int i = 0;i < num;i++){ //添加几辆就循环扩容几次
                bikes = Arrays.copyOf(bikes,bikes.length+1);
                //判断bike的数据类型是ofo的情况
                if(bikes instanceof OfoBike[]){
                    OfoBike ofoBikes[] = (OfoBike[]) bikes;
                    ofoBikes[ofoBikes.length-1] = new OfoBike((ofoBikes.length+100),(bikeCompany.getBikeCompanyName()+
                            (ofoBikes.length+100)),1,null);
                    bikeCompany.setSum(ofoBikes.length);
                    bikeCompany.setBikes(ofoBikes);
                    //判断bike的数据类型是摩拜的情况
                }else if(bikes instanceof MoBike[]){
                    MoBike moBikes[] = (MoBike[]) bikes;
                    moBikes[moBikes.length-1] = new MoBike((moBikes.length+300),(bikeCompany.getBikeCompanyName()+
                            (moBikes.length+100)),1,null);
                    bikeCompany.setSum(moBikes.length);
                    bikeCompany.setBikes(moBikes);
                    //判断bike的数据类型是哈罗单车的情况
                }else {
                    HelloBike helloBikes[] = (HelloBike[]) bikes;
                    helloBikes[helloBikes.length-1] = new HelloBike((helloBikes.length+200),(bikeCompany.getBikeCompanyName()+
                            (helloBikes.length+100)),1,null);
                    bikeCompany.setSum(helloBikes.length);
                    bikeCompany.setBikes(helloBikes);
                }
            }
            System.out.println("添加成功！");
        }else
            System.out.println("添加失败！");
    }

    /**
     * 删除单车
     */
    @Override
    public void deleteBikes(BikeCompany bikeCompany,int bid) {
        if(bikeCompany != null){ //判断传入的参数是否合法
            Bike bikes[] = bikeCompany.getBikes();
            //判断bike的数据类型是ofo的情况
            if(bikes instanceof OfoBike[]){
                int index = -1;
                OfoBike ofoBikes[] =(OfoBike[]) bikes;
                //找到要查找编号的那个的索引
                for (int i = 0; i < ofoBikes.length; i++) {
                    if(bid == ofoBikes[i].getBid()){
                        index = i;
                        break;
                    }
                }
                if(index == -1){
                    System.out.println("没有找到该车辆！");
                    return;
                }else {
                    for (int i = index; i < ofoBikes.length-1; i++) {
                        ofoBikes[i] = ofoBikes[i+1];        //索引之后的对象全往前移
                    }
                }
                ofoBikes = Arrays.copyOf(ofoBikes,ofoBikes.length-1);
                bikeCompany.setSum(ofoBikes.length);    //总长度-1
                bikeCompany.setBikes(ofoBikes);         //将新的bike数组给company
                System.out.println("删除成功！");
            }else if(bikes instanceof MoBike[]){
                int index = -1;
                MoBike moBikes[] =(MoBike[]) bikes;
                //找到要查找编号的那个的索引
                for (int i = 0; i < moBikes.length; i++) {
                    if(bid == moBikes[i].getBid()){
                        index = i;
                        break;
                    }
                }
                if(index == -1){
                    System.out.println("没有找到该车辆！");
                    return;
                }else {
                    for (int i = index; i < moBikes.length-1; i++) {
                        moBikes[i] = moBikes[i+1];        //索引之后的对象全往前移
                    }
                }
                moBikes = Arrays.copyOf(moBikes,moBikes.length-1);
                bikeCompany.setSum(moBikes.length);    //总长度-1
                bikeCompany.setBikes(moBikes);         //将新的bike数组给company
                System.out.println("删除成功！");
            }else {
                int index = -1;
                HelloBike helloBikes[] =(HelloBike[]) bikes;
                //找到要查找编号的那个的索引
                for (int i = 0; i < helloBikes.length; i++) {
                    if(bid == helloBikes[i].getBid()){
                        index = i;
                        break;
                    }
                }
                if(index == -1){
                    System.out.println("没有找到该车辆！");
                    return;
                }else {
                    for (int i = index; i < helloBikes.length-1; i++) {
                        helloBikes[i] = helloBikes[i+1];        //索引之后的对象全往前移
                    }
                }
                helloBikes = Arrays.copyOf(helloBikes,helloBikes.length-1);
                bikeCompany.setSum(helloBikes.length);    //总长度-1
                bikeCompany.setBikes(helloBikes);         //将新的bike数组给company
                System.out.println("删除成功！");
            }
        }else
            System.out.println("查找不规范，删除失败！");
    }

    /**
     * 查看所有单车
     */
    @Override
    public void showBikes(BikeCompany[] bikeCompanies) {
        if (bikeCompanies != null) {
            for (int i = 0; i < bikeCompanies.length; i++) {
                //先输出这个公司的信息
                System.out.println("-------------------------------------------");
                System.out.println("公司ID"+"\t"+"公司名称"+"\t"+"单车总量"+"\t"+"借出次数"+"\t");
                System.out.println("-------------------------------------------");
                System.out.println(bikeCompanies[i].getBikeCompanyId()+"\t"+bikeCompanies[i].getBikeCompanyName()+"\t"+"\t"
                        +bikeCompanies[i].getSum()+"\t"+"\t"+bikeCompanies[i].getCount()+"\t");
                System.out.println("-------------------------------------------");
                //再输出这个公司对应的单车的信息
                Bike bikes[] = bikeCompanies[i].getBikes();
                System.out.println("单车编号"+"\t"+"单车名称"+"\t"+"单车状态"+"\t"+"借出时间"+"\t");
                System.out.println("-------------------------------------------");
                for (Bike bike : bikes) {
                    System.out.println(bike.getBid()+"\t"+"\t"+bike.getBname()+"\t"+ BikeUtil.getNameByStatus(bike.getStatus()) +"\t"+bike.getBorrowTime()+"\t");
                    System.out.println("-------------------------------------------");
                }
            }
        }
    }

    /**
     * 借出单车
     */
    @Override
    public void lendBike(BikeCompany bikeCompany,int bid) {
        if(bikeCompany != null){//判断传入参数是否合法
            Bike bikes[] = bikeCompany.getBikes();
            int index = -1;
            for (int i = 0; i < bikes.length; i++) {
                if(bid == bikes[i].getBid()){
                    index = i;  //找到编号要借出车的索引
                    break;
                }
            }
            if(index == -1){
                System.out.println("没有找到这辆车！");
                return;
            }else {
                String status = BikeUtil.getNameByStatus(bikes[index].getStatus());
                if(status.equals(ConstantUtil.STATUS_ZERO)){//如果该车已经被借走了
                    System.out.println("该车辆已被借出！");
                    return;
                }else {//如果未被借走
                    System.out.println("请输入借出时间：");
                    String time = new Scanner(System.in).next();
                    bikes[index].setBorrowTime(time);
                    bikes[index].setStatus(ConstantUtil.STATUS_0);
                    bikeCompany.setCount(bikeCompany.getCount()+1);
                    bikeCompany.setBikes(bikes);
                    System.out.println("借出成功！");
                }
            }
        }else
            System.out.println("借出失败！");
    }

    /**
     * 归还单车
     */
    @Override
    public void returnBike(BikeCompany bikeCompany,int bid) throws ParseException {
        if(bikeCompany != null){
            Bike bikes[] = bikeCompany.getBikes();
            int index = -1;
            for (int i = 0; i < bikes.length; i++) {
                if(bid == bikes[i].getBid()){
                    index = i;  //找到编号要借出车的索引
                    break;
                }
            }
            if(index == -1){
                System.out.println("没有找到这辆车！");
                return;
            }else {
                String status = BikeUtil.getNameByStatus(bikes[index].getStatus());
                if(status.equals(ConstantUtil.STATUS_ONE)){
                    System.out.println("该车辆尚未被借出，无法执行还车操作！");
                    return;
                }else {
                    SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(sd.format(date));//当前还车时间
                    Date d1=sd.parse(bikes[index].getBorrowTime());
                    Date d2=sd.parse(sd.format(date));
                    long charge =(d2.getTime()-d1.getTime())/(24*60*60*1000);
                    System.out.println("您借出了该车"+charge+"天！");
                    System.out.println("一共需要付款"+(charge*ConstantUtil.RENT)+"元！");
                    System.out.println("正在进行还车操作...");
                    bikes[index].setStatus(ConstantUtil.STATUS_1);
                    bikes[index].setBorrowTime(null);
                    bikeCompany.setBikes(bikes);
                    System.out.println("还车成功！");
                }
            }
        }else
            System.out.println("还车失败！");
    }
}