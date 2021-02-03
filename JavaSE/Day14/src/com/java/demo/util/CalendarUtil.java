package com.java.demo.util;

import java.util.Calendar;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-15:28
 * @Since:jdk1.8
 * @Description:TODO
 */
public class CalendarUtil {
    /**
     * 获取当前时间
     * @return
     */
    public static Calendar getNow() {
        Calendar cal = Calendar.getInstance();//获取当前时间
        return cal;
    }

    /**
     * 获取具体时间
     * @param cal
     */
    public static void getCalendar(Calendar cal){
        System.out.print(cal.get(Calendar.YEAR) + "年");
        System.out.print((cal.get(Calendar.MONTH) + 1) + "月");
        System.out.print(cal.get(Calendar.DATE) + "日 ");
        System.out.print(cal.get(Calendar.HOUR) + ":");
        System.out.print(cal.get(Calendar.MINUTE) + ":");
        System.out.println(cal.get(Calendar.SECOND));
    }

    /**
     * 设置时间
     * @param cal
     * @param year
     * @param month
     * @param day
     */
    public static void setCalendar(Calendar cal,int year,int month,int day){
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DATE,day);
    }

}