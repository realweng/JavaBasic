package com.java.homework.clazz;

import com.java.homework.bean.Student;
import com.java.homework.util.DateUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/5-16:55
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClassDemo {
    public static void getClassInfo(){
        //Class类的实例用于记录对象的类描述信息
        //第一种方式：直接类名.class
        Class clazz=Student.class;
        try {
            //创建对象 --> 默认使用的是无参数构造方法（public）
            Student student = (Student) clazz.newInstance();
            //获取成员变量
            Field fields[] = clazz.getDeclaredFields();
            Field stuId = clazz.getDeclaredField("stuId");
            System.out.println("获取到成员变量："+stuId);
            System.out.println(Arrays.toString(fields));

            //获取成员方法
            Method[] methods = clazz.getMethods();
            //根据成员方法的名称 才能去获取该方法【名字 数据类型】
            Method setStuAge = clazz.getMethod("setStuAge", Integer.class);
            //使用这个成员方法
            setStuAge.invoke(student,23);
            System.out.println(student.getStuAge());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> getObject(Class clazz) throws Exception {
        List<Object> stuList = new ArrayList<>(10);
        for (int i = 100; i < 110; i++) {
            Student student = (Student) clazz.newInstance();
            //获取setId方法和setName方法
            Method setStuId = clazz.getDeclaredMethod("setStuId", Integer.class);
            setStuId.invoke(student, i);
            Method setStuName = clazz.getDeclaredMethod("setStuDate", Date.class);
            setStuName.invoke(student, DateUtil.stringToDate("2021-03-07"));
            stuList.add(student);
        }
        return stuList;
    }

    public static void main(String[] args) {
getClassInfo();
        try {
            List<Object> object = getObject(Student.class);
            object.forEach(o->{
                Student student =(Student) o;
                System.out.println(student.getStuId()+"\t"+student.getStuDate());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}