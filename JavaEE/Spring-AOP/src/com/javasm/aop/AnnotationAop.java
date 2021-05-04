package com.javasm.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:32
 * @Since:jdk1.8
 * @Description:注解实现AOP
 */
@Component
@Aspect
public class AnnotationAop {
    /**
     * Jvm对方法区中方法的具体描述
     * 访问修饰符 返回值全名 方法全名（参数列表）
     * public com.lang.String com.javasm.test.Test.abc(params..)
     * 切面点
     * @Pointcut("execution(* com.javasm.*.*.*(..))")
     */
    @Pointcut("execution(* com.javasm.proxy.*.pay(..))")
    public void pointCut(){ }
    @Pointcut("execution(* com.javasm.*.*.*(..))")
    public void pointCut1(){ }
    @Pointcut("execution(* com.javasm.proxy.*.*(..))")
    public void pointCut2(){ }

    @Before("pointCut()") //执行方法之前执行，参数表示用哪一个切点（方法）
    /**
     * 执行方法之前执行
     */
    public void doBefore(){
        System.out.println(this+"\ndoBefore()开始执行...");
    }
}