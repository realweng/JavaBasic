package com.java.wxg.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-18:54
 * @Since:jdk1.8
 * @Description:时间工具类
 */
public class DateUtil {
    public static int checkClockInTime(Date clockTime) {
        //打卡时间 与 每天早上的8点钟比较
        int clockResult = 0;
        //每天早上的8点钟
        Calendar calendar = Calendar.getInstance();
        //设置时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
//        System.out.println(clockTime.getTime());
//        System.out.println(calendar.getTimeInMillis());
        //获取毫秒数
        if ((clockTime.getTime() - calendar.getTimeInMillis()) < 0) {
            clockResult = 1;
        }else{
            clockResult = 0;
        }
//        System.out.println(clockResult);
        return clockResult;
    }
}