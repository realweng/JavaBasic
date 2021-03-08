package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/16-19:03
 * @Since:jdk1.8
 * @Description:算法练习
 */
public class HomeWork3 {
    public static void main(String []args){
        //问题1：求一光年是多少千米
        long speed = 299792458;
        int s = 60,m = 60,h = 24,day = 365;
        long km;
        km = speed*s*m*h*day/1000;
        System.out.println("问题1："+"一光年是"+km+"千米");

        //问题2：根据天数（46）计算周数和剩余的天数
        int day1 = 46;
        System.out.println("问题2：46天一共"+(46/7)+"整周 余"+(46%7)+"天");

        //问题3：已知圆的半径radius= 1.5，求其面积
        double radius = 1.5;
        System.out.println("问题3：已知圆的半径radius= 1.5，其面积为："+(Math.PI*Math.pow(radius,2)));

        //问题4：较大的扇子
        double a,b,max;
        a = Math.PI * Math.pow(26.5,2) * (134.6/360);
        b = Math.PI * Math.pow((36.5-12.3)/2,2);
        if(a<b){
            System.out.println("问题4：选择B扇");
        }
        else
            System.out.println("问题4：选择A扇");

        //问题5：变量值互换
        int e=10,f=20,temp;
        temp = e;
        e = f;
        f = temp;
        System.out.println("问题5：e和f值互换"+ e +" "+ f);

        //问题6：三位数各个位数的和
        int num = 123;
        int sum = 0;
        sum = num/100 + (num%100)/10 +num%10;
        System.out.println("问题6：123各个位数之和为："+sum);

        //问题7：摄氏度与华氏度转化
        double tp = 16; //假设摄氏度为16
        System.out.println("问题7：假设摄氏度为16度则对应的华氏度："+(tp*9/5+32)+"度");
    }
}