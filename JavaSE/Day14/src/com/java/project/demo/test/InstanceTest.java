package com.java.project.demo.test;

import com.java.project.demo.util.InstanceUtil;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-15:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public class InstanceTest {
    public static void main(String[] args) {
        System.out.println(InstanceUtil.getNow());
        System.out.println(InstanceUtil.formatDate(InstanceUtil.getNow()));
        String s = InstanceUtil.getNow().toString();
        InstanceUtil.parseInstant(s);
        InstanceUtil.parseLocalDate(s);
    }
}