package com.java.project.demo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-15:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public class InstanceUtil {
    /**
     * 获取当前时间
     * @return
     */
    public static Instant getNow() {
        return Instant.now(Clock.offset(Clock.systemUTC(), Duration.ofHours(8)));
    }

    /**
     * 将instant类型转成字符串类型
     * @param instant
     * @return
     */
    public static String formatDate(Instant instant){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        return dtf.format(instant);
    }

    /**
     * 转成instant默认格式
     * @param instant
     * @return
     */
    public static Instant parseInstant(String instant){
        return  Instant.parse(instant);
    }

    /**
     * 将字符串转成LocalDate日期格式
     * @param date
     * @return
     */
    public static LocalDate parseLocalDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(date);
        LocalDate parse = LocalDate.parse(date,dateTimeFormatter);
        return parse;
    }

}