package com.javasm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
     * pointcut切面点 切入某一层级的一些方法
     * JoinPoint 切入点 当前按照切面被拦截的某一个具体方法信息
     * ProceedingJoinPoint 执行期间的切入点
     *
     * @Before 方法执行前执行
     * @After 方法执行完执行
     * @AfterReturning 方法正确返回执行
     * @AfterThrowing 方法报错执行
     *
     * @Around 在@before前执行. 执行了proceed后 执行@after. 一般可以用Around来代替上述四个通知类型
     * Around可以解决想要结合前后通知来运算一些数据. 涉及到创建变量.
     * @before和@After分别在不同的方法中,无法进行变量创建. 当前切面类Spring会按照单例创建实例,不允许创建成员属性,会导致线程不安全.
     * 单例多线程涉及到变量可以使用ThreadLocal来解决线程安全的问题.
     *
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
    public void doBefore(JoinPoint joinPoint){
        System.out.println(this+"\ndoBefore()开始执行..."+joinPoint);
    }

    @After("pointCut()")
    public void doAfter(){
        System.out.println("doAfter执行...");
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void doAfterThrowing(Exception e){
        System.out.println("doAfterThrowing执行..." + e.getLocalizedMessage());
    }

    @AfterReturning(pointcut = "pointCut()",returning = "o")
    public void doAfterReturning(Object o){
        System.out.println("doAfterReturning执行..."+ o);
    }

    /**
     * 环绕通知需要通过 proceedingJoinPoint.proceed()来执行方法 将
     * 该方法的返回结果进行返回 如果出现异常则将错误抛出
     * 否则对应的方法就无法接收返回值或者异常信息
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnValue = null;
        System.out.println("环绕通知开始...");
        System.out.println("before");
        try {
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("return");
        } catch (Throwable throwable) {
            System.out.println("error 异常"+throwable.getLocalizedMessage());
            throw throwable;
        }finally {
            System.out.println("环绕通知结束");
        }
        return returnValue;
    }

}