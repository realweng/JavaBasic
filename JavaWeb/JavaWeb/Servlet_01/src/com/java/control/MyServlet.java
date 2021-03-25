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
 * @Date：2021/3/25-10:45
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向浏览器响应内容
        PrintWriter pw = resp.getWriter();
        // 将字符串内容通过io流写到浏览器上
        pw.write("hello,world!");
        // 刷新缓冲区
        pw.flush();
        // 关闭io流
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}