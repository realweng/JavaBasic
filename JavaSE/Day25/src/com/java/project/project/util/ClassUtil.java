package com.java.project.project.util;

import com.java.project.project.bean.Dept;
import com.java.project.project.bean.Emp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    public static String getMethodName(String columnLabel) {
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
     * 获取类型
     * @param className
     * @return
     */
    private static Class getClass(String className){
        Class clazz = null;
        try {
            //时间
            if(className.equals("java.sql.Timestamp")){
                className = "java.util.Date";
            }
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 赋值
     * @param labelName
     * @param className
     * @param object
     * @param objectValue
     * @param clazz
     */
    public static void invoke(String labelName,String className,Object object,Object objectValue,Class clazz){
        //获取方法名
        String methodName = getMethodName(labelName);
        //再获取特殊处理的名称
        String deptMethodName = getDeptMethodName(clazz,methodName);
        //获取类型
        Class aClass = getClass(className);
        try {
            //判断
            if(deptMethodName != null && deptMethodName.equals("setDept")){
                //反射dept的对象
                Class aClass1 = Class.forName("com.java.project.project.bean.Dept");
                //创建dept对象
                Dept object1 = (Dept) aClass1.newInstance();
                //在dept的方法
                Method declaredMethod = aClass1.getDeclaredMethod(methodName, aClass);
                //再赋值
                declaredMethod.invoke(object1,objectValue);
                //反射
                Method method = clazz.getDeclaredMethod(deptMethodName, aClass1);
                //赋值
                method.invoke(object,object1);
            } else{
                //反射
                Method method = clazz.getDeclaredMethod(methodName, aClass);
                //赋值
                method.invoke(object,objectValue);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 特殊处理dept名称
     * @param clazz
     * @param methodName
     * @return
     */
    private static String getDeptMethodName(Class clazz,String methodName){
        String methodName1 = null;
        if(clazz == Emp.class){
            if(methodName.equals("setDepId") || methodName.equals("setDepName")){
                methodName1 = "setDept";
            }
        }
        return methodName1;
    }
}