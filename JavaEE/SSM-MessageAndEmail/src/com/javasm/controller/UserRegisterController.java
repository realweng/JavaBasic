package com.javasm.controller;

import com.javasm.entity.DataModel;
import com.javasm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/14-21:08
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/register")
public class UserRegisterController {
    @Resource
    private UserService userService;
    @GetMapping
    public ModelAndView registerPage(){
        return new ModelAndView("base/register");
    }

    @PostMapping
    @ResponseBody
    public DataModel register(String username, String password, String phone, String code){
        System.out.println(String.format("用户名: %s, 密码: %s, 手机号: %s, 验证码: %s",username,password,phone,code));
        DataModel register = userService.register(username, password, phone, code);
        return register;
    }

    @PostMapping("/getCode")
    public DataModel getCode(String phone){
        DataModel<Object> model = new DataModel<>();
        model = userService.getCode(phone);
        return model;
    }
}