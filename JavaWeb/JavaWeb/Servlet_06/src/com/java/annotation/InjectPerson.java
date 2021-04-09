package com.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/9-17:19
 * @Since:jdk1.8
 * @Description:TODO
 */
//注入工具是通过反射来得到注解的信息的，于是保留域必须使用RunTime
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPerson {
    String username();
    int age();
    
}