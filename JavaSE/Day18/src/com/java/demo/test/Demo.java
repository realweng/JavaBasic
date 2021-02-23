package com.java.demo.test;

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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index = (int)(Math.random()* list.size()+1);
            }
        }
    }
}