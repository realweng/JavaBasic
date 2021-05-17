package com.javasm.control;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/28-19:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        // 新值覆盖旧值测试
        String put = map.put("aa", "bb");
        String put1 = map.put("aa", "cc");

        System.out.println(put1);
    }
}