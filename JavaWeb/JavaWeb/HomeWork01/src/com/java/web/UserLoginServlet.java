package com.java.web;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-20:31
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService;
    private User user;
    public UserLoginServlet() {
        userService = new UserServiceImpl();
        user = new User();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        List<User> users = userService.getUser(name,password);
        if (users.size()>0) {
            user = users.get(0);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/listProduct");
        } else
            resp.sendRedirect("/login.jsp");
    }
}