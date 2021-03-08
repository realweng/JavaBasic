package com.java.project.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/22-17:27
 * @Since:jdk1.8
 * @Description:TODO
 */

import com.java.project.student.bean.FootTeam;

import java.util.ArrayList;
import java.util.List;

public class HomeWork1 {
    /**
     * 产生随机数
     */
    public static int randomNum() {
        return (int) (Math.random() * 30 + 1);
    }

    /**
     * 判断奇数还是偶数
     *
     * @param list 传入大的集合.
     * @return 返回小的集合
     */
    public static List select(List<Integer> list) {
        List<Integer> list1 = new ArrayList(10);
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            if (num.intValue() % 2 == 0) {
                list1.add(num);
            }
        }
        return list1;
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 生成一个1-30之间的随机数字，添加到集合中。然后再显示集合
         */
        int num = (int) (Math.random() * 30 + 1);
        List list1 = new ArrayList(10);
        list1.add(num);
        System.out.println(list1);

        /**
         * 用一个大集合存入20个随机数字，然后筛选其中的偶数元素，
         * 放到小集合当中。要求使用自定义的方法来实现筛选。
         */
        List<Integer> list2 = new ArrayList(20);
        for (int i = 0; i < 20; i++) {
            list2.add(randomNum());
        }
        System.out.println(list2);
        System.out.println(select(list2));

        /**
         * 已知有十六支男子足球队参加2008 北京奥运会。写一个程序，把这16 支球队随机分为4 个组。
         * 采用List集合和随机数
         * 2008北京奥运会男足参赛国家：科特迪瓦,阿根廷,澳大利亚,塞尔维亚,荷兰,尼日利亚,
         * 日本,美国,中国,新西兰,巴西,比利时,韩国,喀麦隆,洪都拉斯,意大利。
         */
        List<FootTeam> footList = new ArrayList<>(16);
        List<FootTeam> footList1 = new ArrayList<>(4);
        List<FootTeam> footList2 = new ArrayList<>(4);
        List<FootTeam> footList3 = new ArrayList<>(4);
        List<FootTeam> footList4 = new ArrayList<>(4);
        footList.add(new FootTeam(false, "科特迪瓦"));
        footList.add(new FootTeam(false, "阿根廷"));
        footList.add(new FootTeam(false, "澳大利亚"));
        footList.add(new FootTeam(false, "塞尔维亚"));
        footList.add(new FootTeam(false, "荷兰"));
        footList.add(new FootTeam(false, "尼日利亚"));
        footList.add(new FootTeam(false, "日本"));
        footList.add(new FootTeam(false, "美国"));
        footList.add(new FootTeam(false, "中国"));
        footList.add(new FootTeam(false, "新西兰"));
        footList.add(new FootTeam(false, "巴西"));
        footList.add(new FootTeam(false, "比利时"));
        footList.add(new FootTeam(false, "韩国"));
        footList.add(new FootTeam(false, "喀麦隆"));
        footList.add(new FootTeam(false, "洪都拉斯"));
        footList.add(new FootTeam(false, "意大利"));
        boolean flag = true;
        while (flag){
            if(footList1.size()!=4){
                int num1 = (int)(Math.random()*16);
                if(!footList.get(num1).isFlag()){
                    footList1.add(footList.get(num1));
                    footList.get(num1).setFlag(true);//标记已经分组了
                }
            }
            if(footList2.size()!=4){
                int num1 = (int)(Math.random()*16);
                if(!footList.get(num1).isFlag()){
                    footList2.add(footList.get(num1));
                    footList.get(num1).setFlag(true);//标记已经分组了
                }
            }
            if(footList3.size()!=4){
                int num1 = (int)(Math.random()*16);
                if(!footList.get(num1).isFlag()){
                    footList3.add(footList.get(num1));
                    footList.get(num1).setFlag(true);//标记已经分组了
                }
            }
            if(footList4.size()!=4){
                int num1 = (int)(Math.random()*16);
                if(!footList.get(num1).isFlag()){
                    footList4.add(footList.get(num1));
                    footList.get(num1).setFlag(true);//标记已经分组了
                }
            }
            if(footList1.size()==4&&footList2.size()==4&&footList3.size()==4&&footList4.size()==4){
                flag = false;
            }
        }
        for (int i = 0; i < footList1.size(); i++) {
            System.out.print(footList1.get(i).getName()+"\t\t");
        }
        System.out.println();
        for (int i = 0; i < footList2.size(); i++) {
            System.out.print(footList2.get(i).getName()+"\t\t");
        }
        System.out.println();
        for (int i = 0; i < footList3.size(); i++) {
            System.out.print(footList3.get(i).getName()+"\t\t");
        }
        System.out.println();
        for (int i = 0; i < footList4.size(); i++) {
            System.out.print(footList4.get(i).getName()+"\t\t");
        }
    }
}