package com.javasm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/6-21:41
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SimpleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(handler);
        System.out.println("SimpleInterceptor.preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println(modelAndView.getModel());
//        System.out.println(modelAndView.getViewName());
        System.out.println("SimpleInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println(ex);
        System.out.println("SimpleInterceptor.afterCompletion");
    }
}