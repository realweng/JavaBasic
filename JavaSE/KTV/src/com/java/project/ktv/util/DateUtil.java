package com.java.project.ktv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-15:23
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DateUtil {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);

    /**
     * 获取当前时间
     * @return
     */
    public static Date getNow(){
        Date date = new Date();
        return date;
    }

    /**
     * 获取当前时间毫秒数
     * @param time
     * @return
     */
    public static Date getNow(long time){
        Date date = new Date();
        time = date.getTime();//获取毫秒数
        //System.out.println(time);
        date.setTime(time);
        return date;
    }

    /**
     * 日期格式化
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        if(date == null){
            throw new NullPointerException("日期必须输入");
        }
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     * @param time
     * @return
     */
    public static Date parseString(String time){
        Date returnDate = null;
        if(time == null){
            throw new NullPointerException("日期必须输入！");
        }
        try {
            returnDate = sdf.parse(time);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return returnDate;
    }
}