package com.javasm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.constants.DataModelStatus;
import com.javasm.entity.DataModel;
import com.javasm.entity.UserInfo;
import com.javasm.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    public DataModel addUserInfo(UserInfo userInfo){
        DataModel<UserInfo> model = new DataModel<>(userInfo);
        int i = userInfoService.addUserInfo(userInfo);
        if(i == 0){
            model.setCode(DataModelStatus.ADD_USER_ERROR.getCode());
            model.setMsg(DataModelStatus.ADD_USER_ERROR.getMsg());
        }
        return model;
    }

    @GetMapping("/upd")
    @ResponseBody
    public Object updUserInfo(UserInfo userInfo){
        DataModel<UserInfo> model = new DataModel<>(userInfo);
        int i = userInfoService.updUserInfo(userInfo);
        if(i == 0){
            model.setMsg(DataModelStatus.FAIL.getMsg());
            model.setCode(DataModelStatus.FAIL.getCode());
        }
        return model;
    }

    @GetMapping("/find")
    @ResponseBody
    public DataModel findAll(UserInfo userInfo,@RequestParam(name="page",required = true,defaultValue = "1") Integer page,
                             @RequestParam(name="rows",required = true,defaultValue = "2")Integer rows){
        //只对紧跟着的第一句SQL语句有效
        PageHelper.startPage(page,rows);
        List<UserInfo> list = userInfoService.findAll(userInfo);
        PageInfo<UserInfo> adminPageInfo = new PageInfo<>(list,2);
        return new DataModel(adminPageInfo);
    }

    @GetMapping("/del")
    @ResponseBody
    public DataModel deleteUser(Integer id){
        DataModel<UserInfo> model = new DataModel<>();
        int i = userInfoService.delUserInfoById(id);
        if(i == 0){
            model.setMsg(DataModelStatus.DEL_USER_ERROR.getMsg());
            model.setCode(DataModelStatus.DEL_USER_ERROR.getCode());
        }
        return model;
    }
}