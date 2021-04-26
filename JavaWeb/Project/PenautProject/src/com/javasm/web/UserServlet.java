package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.entity.Suggestion;
import com.javasm.entity.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.RequestDataConvert;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-23:02
 * @Since:jdk1.8
 * @Description:用户接口的servlet
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet<User> {
    private UserService userService = new UserServiceImpl();
    private User user = new User();
    private Suggestion suggestion = new Suggestion();

    //注册
    public String register(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        //获取用户提交的数据
        try {
            user = RequestDataConvert.convertToEntityByField(User.class, request);
            boolean flag = userService.addUser(user);
            message = flag ? "a:{message:'注册成功'}" : "{message:'注册失败'}";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return message;
    }

    //登录
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        //获取数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        user = userService.findUserByNamePwd(userName, pwd);
        message = user!=null ? "a:{message:'登录成功'}":"a:{message:'登录失败'}";
        return message;
    }

    //通过id查询个人信息
    public String findUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        // 获取前端传来的id
        String uidStr = request.getParameter("uid");
        // 数据类型转换
        Integer uid = ConvertUtils.StringConvertInteger(uidStr);
        user = userService.findUserById(uid);
        message = user != null ? "a:" + JSONObject.toJSONString(user) : "a:{message:'查询失败'}";
        return message;
    }

    //建议
    public String suggest(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        //获取用户提交的数据
        try {
            suggestion = RequestDataConvert.convertToEntityByField(Suggestion.class, request);
            boolean flag = userService.addSuggestion(suggestion);
            message = flag ? "a:{message:'提交成功'}" : "{message:'提交失败'}";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return message;
    }
}