package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/29-16:21
 * @Since:jdk1.8
 * @Description:Cookie
 */
@WebServlet("/setCookie")
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("userName","admin");
        Cookie cookie1 = new Cookie("pwd","123456");
        Cookie cookie2 = new Cookie("sex","1");
        Cookie cookie3 = new Cookie("score","100");


        //设置域名 设置不同域名为cookie分类
        cookie1.setDomain("localhost");
        //设置路径，当前的cookie在访问时，url中需要有path中设置的路径才能访问到对应的cookie
        cookie2.setPath("/user");
        //设置cookie有效期，单位是秒 默认有效期与session一致
        cookie3.setMaxAge(60*60*24*30);//设置有效期为30天
        // 将Cookie对象发送到浏览器至少
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.sendRedirect("user/getCookie");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}