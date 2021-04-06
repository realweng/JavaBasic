package com.java.web;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/5-11:02
 * @Since:jdk1.8
 * @Description:判断用户名是否已经被注册
 */
@WebServlet("/userCheck")
public class UserCheckServlet extends HttpServlet {
    private UserService userService;

    public UserCheckServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        String userName = req.getParameter("userName");
        List<User> userList = userService.findUserByName(userName);
        PrintWriter pw = resp.getWriter();
        if (userList.size() > 0) {
            pw.write("该用户名已经被注册");
        }
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}