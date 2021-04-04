package com.javasm.util;

/**
 * 数据类型转换
 *
 * @Author：liulei
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

}
