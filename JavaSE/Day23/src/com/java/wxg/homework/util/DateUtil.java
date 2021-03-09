package com.java.wxg.homework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-18:58
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DateUtil {
    //获取当前时间
    public static Date getNowDate() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static String dateToString(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date stringToDate(String s) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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