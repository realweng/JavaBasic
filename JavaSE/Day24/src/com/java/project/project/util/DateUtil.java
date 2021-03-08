package com.java.project.project.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:44
 * @Since:jdk1.8
 * @Description:日期工具类
 */
public class DateUtil {
    //获取当前时间
    public static Date getNowDate() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static String dateToString(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date stringToDate(String s) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }

    public static Date stringToTime(String s){
        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }
}