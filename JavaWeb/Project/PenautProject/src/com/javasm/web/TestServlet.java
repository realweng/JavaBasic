package com.javasm.web;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/11-19:14
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/user.do")
public class TestServlet extends BaseServlet<User>{
    public TestServlet() {
        System.out.println("UserServlet实例化");
    }

    /**
     * 显示所有的用户信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseTypeAnnotation
    public String showUserinfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = "Userinfo中show方法";
        return message;
    }

    /**
     * 添加用户信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public String saveUserinfo(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = "";
        if ("admin".equals(user.getUserName())) {
            message = "s:index.jsp";
        } else {
            request.setAttribute("message", "请求成功");
            message = "f:success.jsp";
        }
        return message;
    }
}