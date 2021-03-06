package com.java.project.util;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-10:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClassUtil {
    /**
     * 拼接字段名为方法名
     *stu_id -> setStuId
     * @param columnLabel
     */
    public static String getClassName(String columnLabel) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("set");
        if(columnLabel.contains("_")){
            String[] strings = columnLabel.split("_");
            stringBuffer.append(strings[0].substring(0,1).toUpperCase());
            stringBuffer.append(strings[0].substring(1,strings[0].length()));
            stringBuffer.append(strings[1].substring(0,1).toUpperCase());
            stringBuffer.append(strings[1].substring(1,strings[1].length()));
        }else {
            stringBuffer.append(columnLabel.substring(0,1).toUpperCase());//首字母转大写
            ;
        }
        return stringBuffer.toString();
    }

    /**
     * 获取字段类型
     * @param className
     * @return
     */
    public static Class getClass(String className){
        Class clazz = null;
        try {
            if(className.equals("java.sql.Timestamp")){
                className = "java.util.Date";
            }
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}