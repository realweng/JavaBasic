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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-20:51
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;//用户业务处理对象
    private User user;//用户对象

    /**
     * 构造器 初始化数据
     */
    public RegisterServlet() {
        userService = new UserServiceImpl();
        user = new User();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        //获取页面的数据
        String userName = req.getParameter("userName");//获取name为userName文本框的值
        String pwd = req.getParameter("pwd");//获取name为pwd文本框的值
        String sex = req.getParameter("sex");// 单选按钮
        String[] aihaos = req.getParameterValues("aihao");// 复选框
        String address = req.getParameter("address");// 下拉列表(单选)
        String myFile = req.getParameter("myFile");// file选择文件（暂时只能获取文件名）

        resp.setContentType("text/html;charset=utf-8");//设置响应的编码格式
        PrintWriter pw = resp.getWriter();

        //先通过用户名查询数据库，先判断用户名是否已经被注册过
        List<User> userList = userService.findUserByName(userName);
        int result = 0;//判断是否注册成功
        if (userList.size() > 0) {
            pw.write("<h1>该用户名已经被注册！！！</h1>");
        } else {
            //将输入的值存入实体对象中
            user.setUserName(userName);
            user.setPwd(pwd);
            user.setSex(sex);
            user.setAihaos(Arrays.toString(aihaos));
            user.setAddress(address);
            user.setMyFile(myFile);
            user.setRegisterDate(new Date());
            //将实体对象的数据传到数据库
            result = userService.addUser(user);

            pw.write("<table border='1px' cellspacing='0px'>");
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
            pw.write("<td>" + sex + "</td>");
            pw.write("</tr>");

            pw.write("<tr>");
            pw.write("<td>爱好：</td>");
            pw.write("<td>" + Arrays.toString(aihaos) + "</td>");
            pw.write("</tr>");

            pw.write("<tr>");
            pw.write("<td>地址：</td>");
            pw.write("<td>" + address + "</td>");
            pw.write("</tr>");

            pw.write("<tr>");
            pw.write("<td>文件名：</td>");
            pw.write("<td>" + myFile + "</td>");
            pw.write("</tr>");

            pw.write("<tr>");
            pw.write("<td>注册时间：</td>");
            pw.write("<td>" + user.getRegisterDate() + "</td>");
            pw.write("</tr>");

            pw.write("</table>");
        }

        String url = "";//要跳转的地址值

        //响应（跳转）
        if (result > 0) {
            pw.write("<h1><a href='login.html'>注册成功，3秒后跳转到登录页面...</a></h1>");
            url = "login.jsp";
        } else {
            pw.write("<h1><a href='register.html'>注册失败，3秒后跳转到注册页面...</a></h1>");
            url = "register.jsp";
        }

        //注册成功或失败3秒后跳转到登录界面
        pw.write("<script> function goLogin(){location.href=" + "'" + url + "'" + "}; setTimeout('goLogin()',3000);</script>");
        pw.flush();
        pw.close();

    }
}