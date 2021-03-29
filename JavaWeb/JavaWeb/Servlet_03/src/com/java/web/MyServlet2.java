package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/29-16:37
 * @Since:jdk1.8
 * @Description:获取设置的cookie
 */
@WebServlet("/user/getCookie")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过请求对象获取cookie数组
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        for (Cookie cookie : cookies) {
            out.write(cookie.getName()+":"+cookie.getValue()+"<br />");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}