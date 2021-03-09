package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/16-16:51
 * @Since:jdk1.8
 * @Description:王者荣耀英雄
 */
public class HomeWork2 {

    public static void main(String[] args) {
    /*
    名字：后羿              String
    性别：男                char
    价格：8888金币          int
    定位：ADC               String
    技能：远程输出           String
    伤害：物理伤害           String
    上手难度：2颗星          byte
    英雄故事：来源于神话故事  String
    是否有控制技能：有       boolean
    */
        String name = "后羿";
        char sex = '男';
        int price = 8888;
        String adc = "AD Carry";
        String function = "远程输出";
        byte star = 2;
        String story = "来源于神话故事";
        boolean control = true;
        System.out.println("名字"+name);
        System.out.println("性别"+sex);
        System.out.println("价格"+price);
        System.out.println("定位"+adc);
        System.out.println("技能"+function);
        System.out.println("上手难度"+star);
        System.out.println("英雄故事"+story);
        System.out.println("是否有控制技能"+control);
    }
}