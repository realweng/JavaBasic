package com.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/2-14:53
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");

        // 获取商品名称
        String productName = request.getParameter("name");
        // 判断
        String message = "aaa".equals(productName) ? "不可用" : "可用";

//        System.out.println(1 / 0);

        PrintWriter out = response.getWriter();
        out.write(message);
        out.flush();
        out.close();
    }
}