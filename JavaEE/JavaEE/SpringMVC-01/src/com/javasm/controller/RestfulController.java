package com.javasm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/5-22:14
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/rest")
public class RestfulController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("1111");
        return "index";
    }

//    @RequestMapping(path = "getUser",method = {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getUser/{id}") //上面的简写

    public String getUser(@PathVariable("id") Integer id){
        System.out.println("请求成功！+id:"+id);
        return "index";
    }

}