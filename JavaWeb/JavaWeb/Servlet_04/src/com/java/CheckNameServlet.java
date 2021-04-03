package com.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/2-15:01
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // 获取商品名称
        String name = req.getParameter("name");
        // 判断
        if("aaa".equals(name)){
            req.setAttribute("message","已经存在");
        }else {
            req.setAttribute("message","不存在，可正常输入");
        }
        req.setAttribute("name",name);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}