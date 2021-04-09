package com.java.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:04
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取session对象
        HttpSession session = request.getSession();
        // 获取session中userName
        Object object = session.getAttribute("classInfo");
        // 获取请求的url
        String requestURI = request.getRequestURI();

        // 是否需要放行
        if (object != null || "/customer.do".equals(requestURI) || "/".equals(requestURI) || "/login.jsp".equals(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);// 放行
        } else {// 为登录不需要放行
            request.setAttribute("message", "请登录！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}