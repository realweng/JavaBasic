package com.java.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:36
 * @Since:jdk1.8
 * @Description:作业5
 */

import com.java.demo.util.Base64Util;
import com.java.demo.util.DateUtil;
import com.java.demo.util.MessageUtil;
import com.java.homework.bean.Security;
import com.java.homework.bean.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现学生注册和登录，显示成绩：
 * 【要求：根据需求分析学生的实体类，要有注册时间，注册时间为当前系统时间】，
 * 学生注册的时候，要求将学号{随机生成了一个四位数}和身份证号进行加密。
 * 并且要求可以选择进行哪种方式来加密：1、Base64  2、MD5加密。
 * 显示学生的信息，可以自由选择是否公开原学号和身份证号。
 * 当用户选择公开的时候显示原学号和身份证号。如果选择不公开则不显示！
 * 登录成功，显示成绩！
 */
public class HomeWork5 {
    static private Student students[] = new Student[2]; //初始化2个学生
    static private Scanner scanner = new Scanner(System.in);;

    /**
     * 信息初始化
     */
    public static void init(){
        Security security = new Security(false,false,
                MessageUtil.encryption(Integer.valueOf(1000).toString()),
                MessageUtil.encryption("342401197310244992"),"2021-1-31 12:00:00");
        Security security1 = new Security(true,true,
                Base64Util.encryption(Integer.valueOf(1001).toString()),
                Base64Util.encryption("442401197810244831"),"2021-2-3 12:00:00");
        students[0] = new Student(1000,"张三","342401197310244992",90,security);
        students[1] = new Student(1001,"李四","442401197810244831",100,security1);
    }

    /**
     * 随机数用来产生4位数学号
     * @return
     */
    private int random(){
        int num = (int)(Math.random()*9000+1000);
        return num;
    }

    /**
     * 学生注册的方法
     */
    public void register(Student students[]){
        System.out.println("正在生成学号....");
        int num = random();
        if(find(students,num)!=-1){
            System.out.println("学号生成重复，请重新注册生成....");
            return ;
        }else {
            System.out.println("学号生成成功，您的学号为："+num);
            students = Arrays.copyOf(students,students.length+1);
            students[students.length-1] = new Student(); //避免空指针
            students[students.length-1].setStuNum(num);//把学号存入学生实体中
            System.out.println("请输入姓名：");
            String name = scanner.next();
            students[students.length-1].setName(name);//把姓名存入学生实体中
            System.out.println("请输入身份证号：");
            String id = scanner.next();
            String reg = "^\\d+$";
            if(!id.matches(reg)){
                System.out.println("身份证输入不合规范！");
                return;
            }
            students[students.length-1].setId(id);//把身份证号码存入学生实体中
            System.out.println("请输入您的成绩：");
            float grade = scanner.nextFloat();
            students[students.length-1].setGrade(grade);//把成绩存入学生实体中
            System.out.println("是否使用Base64加密(选否使用MD5加密) y/n?");
            String select = scanner.next();
            Security securitiy = new Security();//临时存放安全信息
            if(select.equals("y")){
                System.out.println("您选择了Base64加密方式");
                securitiy.setBase(true);
                securitiy.setSecId(Base64Util.encryption(id));
                securitiy.setSecStuNum(Base64Util.encryption(Integer.valueOf(num).toString()));
               // System.out.println(Base64Util.encryption(Integer.valueOf(num).toString()));
            }else{
                System.out.println("您选择了MD5加密方式");
                securitiy.setBase(false);
                securitiy.setSecId(MessageUtil.encryption(id));
                securitiy.setSecStuNum(MessageUtil.encryption(Integer.valueOf(num).toString()));
            }
            System.out.println("请确认是否公开您的私密信息：y/n");
            String confirm = scanner.next();
            if(confirm.equals("y")){
                securitiy.setShow(true);
            }else {
                securitiy.setShow(false);
            }
            Date date = new Date();//获取注册完成的时间
            //存储当前时间
            securitiy.setTime(DateUtil.formatDate(date)); //格式化日期信息
            students[students.length-1].setSecurity(securitiy); //存储安全信息
            this.students = Arrays.copyOf(students,students.length); //存储信息到静态变量
            System.out.println("注册成功！");
        }

    }

    /**
     * 学生登录的方法
     */
    public void login(Student[] students){
        System.out.println("请输入你的学号");
        int num = scanner.nextInt();
        if(find(students,num)!=-1){
            //System.out.println("找到了");
            int index = find(students,num);
            System.out.println("请输入身份证号：");
            String id = scanner.next();
            //System.out.println(Base64Util.encryption(Integer.valueOf(num).toString()));
            //该用户采用Base64加密
            if(students[index].getSecurity().isBase()){
                if(students[index].getSecurity().getSecStuNum().equals(Base64Util.encryption(Integer.valueOf(num).toString()))
                &&students[index].getSecurity().getSecId().equals(Base64Util.encryption(id))){
                    System.out.println("学号和身份证正确，登录成功");
                } else
                    System.out.println("学号或身份证号错误，登录失败");
            }else {
                if(students[index].getSecurity().getSecStuNum().equals(MessageUtil.encryption(Integer.valueOf(num).toString()))
                &&students[index].getSecurity().getSecId().equals(MessageUtil.encryption(id))){
                    System.out.println("学号和身份证正确，登录成功");
                }else
                    System.out.println("学号或身份证号错误，登录失败");
            }
        }else
            System.out.println("用户不存在！");
    }

    /**
     * 查找对应学号的学生（也可用于判断学生的学号是否被占用）
     * @return true存在这个学生 false不存在这个学生
     */
    public int find(Student students[], int num){
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if(students[i].getStuNum()==num){
                //System.out.println("该学生存在");
                index = i;
                return index;
            }
        }
        return index;
    }

    public void show(Student students[]){
        System.out.println("姓名\t"+"\t学号\t\t\t\t"+"身份证号\t\t\t\t\t"+"\t成绩\t"+"\t\t\t\t注册时间");
        for (int i = 0; i < students.length; i++) {
            System.out.println("------------------------------------------------------------------------------------------------------");
            if(students[i].getSecurity().isShow()){
                System.out.println(students[i].getName()+"\t\t"+students[i].getStuNum()+"\t\t\t"+
                        students[i].getId()+"\t\t\t\t"+students[i].getGrade()+"\t\t\t\t"+
                        students[i].getSecurity().getTime());
            }else {
                System.out.println(students[i].getName()+"\t\t"+"学号拒绝展示"+"\t\t\t"+
                        "身份证号码拒绝展示"+"\t\t\t"+students[i].getGrade()+"\t\t\t\t"+
                        students[i].getSecurity().getTime());
            }
        }
    }


    /**
     * 用户界面
     */
    public void start(){
        init();//初始化
        boolean isFlag = true;
        while (isFlag){
            System.out.println("*******1.登录 2.注册 3.展示 4.退出*******");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    System.out.println("------->登录");
                    login(students);
                    break;
                case 2:
                    System.out.println("------->注册");
                    register(students);
                    break;
                case 3:
                    System.out.println("------->展示");
                    show(students); //查询初始信息
                    break;
                case 4:
                    System.out.println("------->退出");
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        new HomeWork5().start();
    }
}