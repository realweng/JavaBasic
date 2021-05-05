package com.javasm.controller;

import com.javasm.entity.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/5-17:44
 * @Since:jdk1.8
 * @Description:用户controller 当前类相当于Servlet, 也就是Spring中的Handler处理器
 */
@Controller //标记当前类为Handler(处理器)，交给SpringMVC托管
@RequestMapping("/user") // 为当前的handler配置路径

public class UserInfoController {

    @RequestMapping("/get") //为当前方法配置url路径
    /**
     * 获取用户信息
     */
    public String getUser(Integer id,String userName) {
        System.out.println("获取用户信息 id:"+id+" userName:"+userName);
        return "success";
    }

    /**
     * SpringMVC在调用HandlerMethod时除了匹配包装类，
     * 还会根据对象的成员属性与Request域中的参数进行匹配
     * @param userInfo
     * @return
     */
    @RequestMapping("/get1")
    public String getUser(UserInfo userInfo) {
        System.out.println("获取用户信息 "+userInfo);
        return "success";
    }

    /**
     *RequestParam可以手动映射当前参数在请求域中的名称
     * name:request域中的名称
     * required:是否为必填的值，设置为true如果没有参数传进来就会报错
     * defaultValue:默认值
     */
    @RequestMapping("/get2")
    public String getUser(Integer id, @RequestParam(name = "user",required = true,defaultValue = "defaultName") String userName, UserInfo userInfo) {
        System.out.println("获取用户信息userInfo:"+userInfo);
        System.out.println("id:"+id+"  userName:"+userName);
        return "success";
    }

    /**
     * DateTimeFormat只是一个注解 具体实现是在mvc中
     * @param time
     * @param userInfo
     * @return
     */
    @RequestMapping("/login")
    public String login(@DateTimeFormat(pattern = "yyyy-MM-dd") Date time, UserInfo userInfo){
        System.out.println("登录时间 : " + time  + " , userInfo :" + userInfo);
        return "success";
    }

    @RequestMapping("/find")
    public String findUser(Integer id, Model model){
        System.out.println(id);
        model.addAttribute("msg","请求成功");
        model.addAttribute("userInfo",new UserInfo(1,"张三",new Date()));
        return "/success.jsp";
    }

    @RequestMapping("/find1")
    public ModelAndView findUser(Integer id){
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/success.jsp"); //设置视图名
        modelAndView.addObject("msg","请求成功"); //添加响应参数
        modelAndView.addObject("userInfo",new UserInfo(1,"张三",new Date()));
        return modelAndView;
    }

    @RequestMapping("/find2")
    public ModelAndView findUser(Integer id, HttpServletRequest request, HttpServletResponse response){
        String id1 = request.getParameter("id");
        System.out.println(id1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/success.jsp"); //设置视图名
        modelAndView.addObject("msg","请求成功1"); //添加响应参数
        modelAndView.addObject("userInfo",new UserInfo(1,"张三1",new Date()));
        return modelAndView;
    }

    @RequestMapping("/setSession")
    public ModelAndView setSession(HttpSession httpSession){
        httpSession.setAttribute("user","张三");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }
    @RequestMapping("/getSession")
    public ModelAndView getSession(HttpSession httpSession,@SessionAttribute("user") Object u){
        Object user = httpSession.getAttribute("user");
        System.out.println("获取session : " + user);
        System.out.println("SessionAttribute 获取session : " + u);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}