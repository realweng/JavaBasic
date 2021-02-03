package com.java.demo.test;

import com.java.demo.util.InstanceUtil;

import java.time.Instant;

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