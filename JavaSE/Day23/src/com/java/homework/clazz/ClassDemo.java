package com.java.homework.clazz;

import com.java.homework.bean.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/5-16:55
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClassDemo {
    public static List<Object> getObject(Class clazz) throws Exception {
        List<Object> stuList = new ArrayList<>(10);
        for (int i = 100; i < 110; i++) {
            Student student = (Student) clazz.newInstance();
            //获取setId方法和setName方法
            Method setStuId = clazz.getDeclaredMethod("setStuId", Integer.class);
            setStuId.invoke(student, i);
            Method setStuName = clazz.getDeclaredMethod("setStuName", String.class);
            setStuName.invoke(student, "Test" + i);
            stuList.add(student);
        }
        return stuList;
    }

    public static void main(String[] args) {

        try {
            List<Object> object = getObject(Student.class);
            object.forEach(o->{
                Student student =(Student) o;
                System.out.println(student.getStuId()+"\t"+student.getStuName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}