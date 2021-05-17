package com.javasm.aop;

import com.javasm.proxy.Alipay;
import com.javasm.proxy.Ipay;
import com.javasm.proxy.WxPay;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AnnotationAopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Ipay ipay = context.getBean(Alipay.class);
        ipay.pay(200);
    }
}