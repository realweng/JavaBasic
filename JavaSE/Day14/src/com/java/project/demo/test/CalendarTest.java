package com.java.project.demo.test;

import com.java.project.demo.util.CalendarUtil;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-15:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CalendarTest {
    public static void main(String[] args) {
        CalendarUtil.getNow();
        CalendarUtil.getCalendar(CalendarUtil.getNow());
    }
}