package com.java.control;

import com.java.entity.User;
import com.java.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/25-15:42
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LoginServlet extends HttpServlet {
    private UserService userService; //用户业务处理对象
    private User user;//用户对象

    /**
     * 构造器 初始化数据
     */
    public LoginServlet() {
        userService = new UserService();
        user = new User();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet请求...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost请求...");
        //设置请求的编码
        req.setCharacterEncoding("utf-8");
        // 获取用户输入的用户名密码
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        // 设置编码格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        //查询用户是否存在
        List<User> userList = userService.findUserByName(userName);
        if (userList.size() > 0) {
            //说明数据库存在该账户，继续判断用户名与密码是否正确
            user = userList.get(0);//获取从数据库中查询到的数据
            // 通过获取请求来的账号密码与后台的账号密码做比对，之后响应结果
            if (user.getUserName().equals(userName) && user.getPwd().equals(pwd)) {
                pw.write("<h1>" + userName + "欢迎你！</h1>");
                pw.write("<table border='1px' cellspacing='0px'>");
                pw.write("<tr>");
                pw.write("<td>用户编号：</td>");
                pw.write("<td>" + user.getUid() + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>账号：</td>");
                pw.write("<td>" + userName + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>密码：</td>");
                pw.write("<td>" + pwd + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>性别：</td>");
                pw.write("<td>" + user.getSex() + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>爱好：</td>");
                pw.write("<td>" + user.getAihaos() + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>地址：</td>");
                pw.write("<td>" + user.getAddress() + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>文件名：</td>");
                pw.write("<td>" + user.getMyFile() + "</td>");
                pw.write("</tr>");

                pw.write("<tr>");
                pw.write("<td>注册时间：</td>");
                pw.write("<td>" + user.getRegisterDate() + "</td>");
                pw.write("</tr>");
                pw.write("</table>");
            } else {
                pw.write("<h1>登录失败！密码输入错误！</h1>");
            }
        }else {
            pw.write("<h1>登录失败！不存在该账户！</h1>");
        }
        pw.flush();
        pw.close();
    }
}