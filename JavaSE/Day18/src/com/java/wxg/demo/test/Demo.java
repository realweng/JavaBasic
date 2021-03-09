package com.java.wxg.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-16:47
 * @Since:jdk1.8
 * @Description:TODO
 */

import java.util.*;

/**
 * 已知有十六支男子足球队参加2008 北京奥运会。
 * 写一个程序，把这16 支球队随机分为4 个组。采用List集合和随机数  2008 北京奥运会男足参赛国家：
 * 科特迪瓦,阿根廷,澳大利亚,塞尔维亚,荷兰,尼日利亚,日本,
 * 美国,中国,新西兰,巴西,比利时,韩国,喀麦隆,洪都拉斯,意大利。
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>(16);
        List<String> list = new ArrayList<>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        //遍历取值
        for (int i = 0; i < 4; i++) {
            //每1次 创建一个新的list
            List<String> list1 = new ArrayList<>(10);
            for (int j = 0; j < 4; j++) {
                //随机数
                int index = (int) (Math.random() * list.size());
                //通过索引取移除值，并且获取到
                String removeName = list.remove(index);
                //添加到集合中
                list1.add(removeName);
            }
            //添加到map
            hashMap.put((i + 1), list1);
        }
    }
}