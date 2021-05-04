package com.javasm.aop;

import com.javasm.proxy.Ipay;
import com.javasm.proxy.WxPay;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-22:38
 * @Since:jdk1.8
 * @Description:TODO
 */
public class XmlAopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        Ipay bean = context.getBean("wxPay",Ipay.class);
        bean.pay(1000);
    }
}