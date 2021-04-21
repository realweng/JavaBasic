package com.javasm.service;

import com.alibaba.fastjson.JSONObject;
import com.javasm.service.impl.BookServiceImpl;

/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/21-15:45
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Test {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        String jsonString = JSONObject.toJSONString(bookService.findBookByAttribution(1, 0, 5));
        System.out.println(jsonString);
    }
}
