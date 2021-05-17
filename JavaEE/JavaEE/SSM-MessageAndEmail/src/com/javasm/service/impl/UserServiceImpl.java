package com.javasm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.constants.Constants;
import com.javasm.constants.DataModelStatus;
import com.javasm.constants.RedisKeyConstants;
import com.javasm.dao.UserDao;
import com.javasm.entity.DataModel;
import com.javasm.entity.User;
import com.javasm.service.RedisService;
import com.javasm.service.UserService;
import com.javasm.utils.SmsUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-18:17
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RedisService redisService;

    /**
     * 用户登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public User userLogin(String userName, String pwd, HttpSession httpSession) {
        User user = userDao.userLogin(userName, pwd);
        if (user != null) {
            httpSession.setAttribute("user", user);
        }
        return user;
    }

    /**
     * 用redis模拟session进行登录状态验证
     *
     * @param userName
     * @param pwd
     * @param
     * @param httpServletResponse
     * @return
     */
    @Override
    public User userLoginByRedis(String userName, String pwd, HttpServletResponse httpServletResponse) {
        User user = userDao.userLogin(userName, pwd);
        if (user != null) {
            Cookie cookie = new Cookie("id",user.getUid().toString());
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);

            //将id存到redis中
            String sessionKey = RedisKeyConstants.USER_SESSION_KEY+user.getUid().toString();
            redisService.setex(sessionKey, Constants.REDIS_SESSION_EXPIRE, JSON.toJSONString(user));
        }
        return user;
    }

    /**
     * 注册用户
     *
     * @param userName
     * @param pwd
     * @return 返回uid
     */
    @Override
    public DataModel register(String userName, String pwd,String phone,String code) {
        DataModel<Object> model = new DataModel<>();
        //查询用户名是否唯一
        //再次校验用户手机号是否未注册

        String key = RedisKeyConstants.SMS_CODE_REGISTER + phone;
        String rcode = redisService.get(key);
        if(rcode != null && rcode.equals(code)){
            //保存注册信息
            userDao.addUser(userName,pwd);
        }else{
            model.setCode(DataModelStatus.REGISTER_CODE_ERROR.getCode());
            model.setMsg(DataModelStatus.REGISTER_CODE_ERROR.getMsg());
        }
        return model;
    }

    /**
     * 发送注册验证码
     *
     * @param phoneNum
     * @return
     */
    @Override
    public DataModel getCode(String phoneNum) {
        DataModel<Object> model = new DataModel<>();
        String code = SmsUtils.sendCode(phoneNum);
        String key = RedisKeyConstants.SMS_CODE_REGISTER + phoneNum;
        redisService.setex(key,Constants.SMS_CODE_REGISTER_EXPIRE,code);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code);
        model.setData(map);
        return model;
    }
}