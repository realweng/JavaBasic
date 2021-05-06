package com.javasm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/6-19:52
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    /**
     * 局部异常
     * @param model
     * @return
     */
    @RequestMapping("/test")
    @ExceptionHandler
    public String errorTest(Exception e,Model model) {
        String viewName = "index";
//        System.out.println(1 / 0);
        System.out.println(e.getLocalizedMessage());
        return "error";
    }

    /**
     *  当前Controller(Handler)发生异常时被调用 (当有全局异常时,当前异常处理优先执行)
     */
    @ExceptionHandler
    public ModelAndView doException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("msg","系统繁忙");
        return modelAndView;
    }
}