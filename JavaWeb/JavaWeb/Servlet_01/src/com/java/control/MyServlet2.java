package com.java.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/25-14:39
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyServlet2 extends HttpServlet {
    /**
     * @param req 请求响应，由tomcat服务器实例化，tomcat服务器会将从客户端传递到服务器的数据包封装到javax.servlet.http.HttpServletRequest
     * @param resp 响应请求
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端的信息
        String remoteHost = req.getRemoteHost();
        // 获取服务器的信息
        // 编码格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("客户端名称："+remoteHost);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}