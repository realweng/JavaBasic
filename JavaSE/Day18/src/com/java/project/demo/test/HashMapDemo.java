package com.java.project.demo.test;

import com.java.project.demo.bean.Student1;

import java.util.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-11:44
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HashMapDemo {
    private Scanner scanner;
    private Map<String, List<Student1>> map;//整体的存储结构
    /**
     * 构造方法 初始化数据
     */
    public HashMapDemo() {
        scanner = new Scanner(System.in);
        map = new HashMap(16);

    }

    /**
     * 存储：班级名-学生成绩（分数） String-List<Integer>
     * 添加和显示
     */
    public void test() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("*********班级成绩管理*******");
            System.out.println("***********1.添加**********");
            System.out.println("***********2.显示**********");
            System.out.println("***********0.退出**********");
            System.out.println("请输入：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 0:
                    isFlag = false;//退出
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 添加信息
     */
    public void add() {
        System.out.println("请输入要添加的班级名称：");
        String className = scanner.next();
        System.out.println("请输入学生的id:");
        int id = scanner.nextInt();
        System.out.println("请输入学生的姓名：");
        String name = scanner.next();
        System.out.println("请输入要添加的分数：");
        int grade = scanner.nextInt();
        if (map.containsKey(className)) { //如果已经存在该班级
            List list1 = map.get(className); //获取已经存储成绩的集合
            list1.add(new Student1(id,name,grade)); //在该集合后加入新成绩
            map.replace(className, list1); //更新map
        } else {//如果没有这个班级
            List<Student1> list = new ArrayList<>(10);;//临时存放分数
            list.add(new Student1(id,name,grade));
            map.put(className, list);
        }
    }

    /**
     * 显示信息
     */
    public void show() {
        map.forEach((key, val) -> {
            System.out.println("班级名称："+key+"\t");
            System.out.println("------------------------");
            for (int i = 0; i < val.size(); i++) {
                System.out.println("学生id:"+val.get(i).getId());
                System.out.println("学生姓名:"+val.get(i).getName());
                System.out.println("学生成绩:"+val.get(i).getGrade());
                System.out.println("-----------------------------");
            }
           // System.out.println(val);
        });
    }

    public static void main(String[] args) {
        new HashMapDemo().test();
    }
}