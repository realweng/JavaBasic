package com.java.wxg.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/29-10:24
 * @Since:jdk1.8
 * @Description:时间工具类
 */
public class DateUtil {
    /**
     * 格式化当前时间
     * @return
     */
    public static String dateForMat(){
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        return sd.format(date);
    }
}