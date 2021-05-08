package com.javasm.component;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/7-17:54
 * @Since:jdk1.8
 * @Description:登录拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}