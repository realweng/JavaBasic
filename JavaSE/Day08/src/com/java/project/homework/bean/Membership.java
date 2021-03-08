package com.java.project.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:57
 * @Since:jdk1.8
 * @Description:作业6的会员类
 */
public class Membership {
    private int vipNum;//会员号
    private String name;  //会员姓名
    private double points;//会员积分

    /**
     * 有参构造
     * @param vipNum 会员号
     * @param name 姓名
     * @param points 积分
     */
    public Membership(int vipNum, String name, double points) {
        this.vipNum = vipNum;
        this.name = name;
        this.points = points;
    }

    /**
     * 判断会员号是否合法的方法
     * @return
     */
    public boolean isVipNumLegal(){
        if(vipNum >= 1000 && vipNum <10000){
            System.out.println("会员号合法，数据保存");
            return true;
        }else
            System.out.println("会员号不合法，请退出");
        return false;
    }

    public boolean isLuckyMember(){
        if((this.vipNum+this.points) % 2 == 0){
            System.out.println("参与抽奖，幸运用户！");
            return true;
        }else
            System.out.println("不是幸运用户");
        return false;
    }


    /**
     * 无参构造
     */
    public Membership() {
    }

    public int getVipNum() {
        return vipNum;
    }

    public void setVipNum(int vipNum) {
        this.vipNum = vipNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}