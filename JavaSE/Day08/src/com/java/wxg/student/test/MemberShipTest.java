package com.java.wxg.student.test;

import com.java.wxg.student.bean.Membership;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-20:12
 * @Since:jdk1.8
 * @Description:作业6会员的测试类
 */
public class MemberShipTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Membership membership = new Membership(1120,"ggg",800);
        boolean isLegal = membership.isVipNumLegal(); //判断会员号是否合法
        if(isLegal){
            boolean isLucky = membership.isLuckyMember(); //判断是否是幸运用户
            if(isLucky){
                System.out.println("返回折扣");
            }
        }
    }
}