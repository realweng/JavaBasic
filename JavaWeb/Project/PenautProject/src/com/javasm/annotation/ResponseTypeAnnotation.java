package com.javasm.annotation;

import com.javasm.myenum.ResponseTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注servlet中的方法的响应方式
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/9-19:35
 * @Since:jdk1.8
 * @Description:TODO
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseTypeAnnotation {
    ResponseTypeEnum responseType() default ResponseTypeEnum.AJAX;
}
