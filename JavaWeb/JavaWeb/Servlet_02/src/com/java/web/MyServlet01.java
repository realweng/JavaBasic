package com.java.web;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/26-16:06
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyServlet01 extends GenericServlet {
    /**
     * 重写service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //类型转换 将ServletRequest和ServletResponse类型转换为HttpServletRequest和HttpServletResponse类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求的方式
        String method = request.getMethod();
        if(method.equals("GET")){
            doGet(request,response);
        }else if(method.equals("POST")){
            doPost(request,response);
        }
    }

    /**
     * 自己定义的doGet方法
     * @param request
     * @param response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("get请求");
    }

    /**
     * 自己定义的doPost方法
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("post请求");
    }
}