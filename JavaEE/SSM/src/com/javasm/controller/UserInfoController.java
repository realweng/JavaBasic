package com.javasm.controller;

import com.javasm.entity.UserInfo;
import com.javasm.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/7-19:40
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/{userId}")
    @ResponseBody
    public Object getUserInfo(@PathVariable("userId") Integer userId){
        HashMap<Object,Object> map = new HashMap<>(16);
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        map.put("userInfo",userInfo);
        return map;
    }

    @GetMapping("/add")
    @ResponseBody
    public Object addUserInfo(UserInfo userInfo){
        HashMap<Object,Object> map = new HashMap<>(16);
        int i = userInfoService.addUserInfo(userInfo);
        if(i > 0){
            map.put("code",200);
            map.put("msg","添加成功");
            map.put("userInfo",userInfo);
        }else {
            map.put("code",400);
            map.put("msg","添加失败");
        }
        return map;
    }
}