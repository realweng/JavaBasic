package com.javasm.controller;

import com.javasm.entity.User;
import com.javasm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-18:18
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/login")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "base/login";
    }

    @PostMapping
    public String login(String username, String password, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        String viewName = "base/main";
//        User user = userService.userLogin(username, password, httpSession);
        User user = userService.userLoginByRedis(username,password,httpServletResponse);
        if(user == null){
            viewName = "base/login";
        }
        return viewName;
    }
}