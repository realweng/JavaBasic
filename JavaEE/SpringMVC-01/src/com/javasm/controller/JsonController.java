package com.javasm.controller;

import com.javasm.entity.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/6-21:21
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/json")
public class JsonController {
    /**
     * 当配置了messageConverter后,使用@ResponseBody时,SpringMVC在响应对象时会自动将对象转换为json
     * 或者将返回类型定义为ResponseEntity. 在SpringMVC的消息转换机制中,优先识别ResponseEntity对象.
     * ResponseEntity对象可以单独设置响应状态码
     *
     * @return
     */
    @GetMapping
    @ResponseBody
    public Object json() {
        HashMap<Object, Object> map = new HashMap<>();
        UserInfo userInfo = new UserInfo(1, "张三", new Date());
        map.put("userInfo", userInfo);
        return map;
    }

    @RequestMapping("/responseEntity")
    public ResponseEntity<Object> testResponseEntity(){
        UserInfo userInfo = new UserInfo(1, "张三", new Date());
//        return ResponseEntity.status(300).build();
        return  ResponseEntity.ok(userInfo);
    }
}