package com.javasm.web;

import com.javasm.entity.AdminUser;
import com.javasm.service.AdminUserService;
import com.javasm.service.impl.AdminUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-20:17
 * @Since:jdk1.8
 * @Description:后台管理用户servlet
 */

@WebServlet("/adminUser.do")
public class AdminUserServlet extends BaseServlet<AdminUser> {
    private AdminUserService adminUserService;
    private AdminUser adminUser;

    /**
     * 构造方法，初始化
     */
    public AdminUserServlet() {
        System.out.println("AdminServlet实例化");
        adminUserService = new AdminUserServiceImpl();
        adminUser = new AdminUser();
    }

    /**
     * 后台管理用户登录
     *
     * @return
     */
    public String adminUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = "";
        // 获取页面数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");

        //  通过账号、密码查询用户信息
        //  findUserByName(userName)查询是否有这个用户，如果存在该用户再做用户名密码的判断
        adminUser = adminUserService.findUserByName(userName);
        if (adminUser != null) {
            if (adminUser.getUserName().equals(userName) && adminUser.getPwd().equals(pwd)) {
                // 登录成功之后，对象需要保存到session中
                request.getSession().setAttribute("user", adminUser);
                // 登录成功之后，显示所有
                message = "s:404.jsp";
//                response.sendRedirect("main.jsp");
            } else {
                request.setAttribute("message", "登录失败，账号密码输入有误");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
                message = "f:login.jsp";
            }
        } else {
            request.setAttribute("message", "不存在该账户！");
            message = "f:login.jsp";
//            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        return message;
    }
}