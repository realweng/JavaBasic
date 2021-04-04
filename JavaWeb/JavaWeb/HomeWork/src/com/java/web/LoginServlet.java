package com.java.web;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-16:01
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取页面数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");

        UserService userinfoService = new UserServiceImpl();
        //  通过账号、密码查询用户信息，调用userinfoservice中的
        //  findUserByName(userName)查询是否有这个用户，如果存在该用户再做用户名密码的判断
        List<User> userList = userinfoService.findUserByName(userName);
        if (userList.size() > 0) {
            User user = userList.get(0);//获取用户对象
            if (user.getUserName().equals(userName) && user.getPwd().equals(pwd)) {
                // 登录成功之后，对象需要保存到session中
                request.getSession().setAttribute("user", user);
                // 登录成功之后，显示所有的商品
                response.sendRedirect("showProduct");
            } else {
                request.setAttribute("message", "登录失败，账号密码输入有误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "不存在该账户！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}