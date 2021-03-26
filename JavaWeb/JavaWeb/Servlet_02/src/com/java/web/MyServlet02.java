package com.java.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/26-16:21
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyServlet02 implements Servlet {
    // servlet中的方法开始----------------------------------------------
    private ServletConfig servletConfig;//  servlet配置信息对象

    /**
     * 初始化
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化数据");
        this.servletConfig = servletConfig;
    }

    /**
     * 获取配置对象
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    /**
     * 执行服务
     *
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
        //获取请求方式
        String method = request.getMethod();
        //不同的请求方式作出不同的响应
        if(method.equals("GET")){
            doGet(request,response);
        }else if(method.equals("POST")){
            doPost(request,response);
        }
    }

    /**
     * 从web.xml中获取配置信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return this.servletConfig.getServletName();
    }

    /**
     * 释放servlet实例
     */
    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    // servlet中的方法结束-------------------------------------------

    /**
     * 自己定义的doGet方法
     *
     * @param request
     * @param response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet请求");
        //获取servlet-name
        String servletName = servletConfig.getServletName();
        // servletContext对象（application对象）
        ServletContext servletContext = servletConfig.getServletContext();
        // web.xml 文件中所有初配置始化参数
        String encoding = servletConfig.getInitParameter("encoding");
        //获取web.xml文件中所有初始化参数名
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

        //设置响应内容的编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("servletName:"+servletName+"<br/>");
        pw.write("servletContext:"+servletContext+"<br/>");
        pw.write("encoding:"+encoding+"<br/>");
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(name);
            pw.write(name + ":" + value + "<br />");
        }
        pw.flush();
        pw.close();

    }

    /**
     * 自己定义的doPost方法
     *
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doPost请求");
    }
}