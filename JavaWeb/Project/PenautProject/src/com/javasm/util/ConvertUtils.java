package com.javasm.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据类型转换
 *
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/27-17:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ConvertUtils {

    public static Integer StringConvertInteger(String value) {
        return value != null && !"".equals(value) ? Integer.valueOf(value) : null;
    }

    public static Float StringConvertFloat(String value) {
        return value != null && !"".equals(value) ? Float.valueOf(value) : null;
    }

    public static Double StringConvertDouble(String value) {
        return value != null && !"".equals(value) ? Double.valueOf(value) : null;
    }

    public static Boolean StringConvertBoolean(String value) {
        return value != null && !"".equals(value) ? Boolean.valueOf(value) : null;
    }

    public static Timestamp StringConvertTimestamp(String value) {
        return value != null && !"".equals(value) ? Timestamp.valueOf(value) : null;
    }

    public static Date StringConvertDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return value != null && !"".equals(value) ? format.parse(value) : null;
    }

}
