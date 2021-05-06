package com.javasm.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/6-20:28
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/page")
    public String page() {
        return "demo/upload";
    }

    @PostMapping
    public String upload(HttpServletRequest request, String nickname, MultipartFile headImg) {
        System.out.println("昵称 : " + nickname);
        System.out.println("头像 : " + headImg);
        System.out.println("文件大小 : " + headImg.getSize());
        System.out.println("文件名称 : " + headImg.getOriginalFilename());
        System.out.println("文件类型 :" + headImg.getContentType());
        System.out.println("文件字段名 : " + headImg.getName());

        // 获取当前原始文件名
        String originalFilename = headImg.getOriginalFilename();
        //按照.截取字符串
        String[] split = originalFilename.split("\\.");
        //获取文件名的后缀
        String suffix = split[split.length - 1];
        //随机字符串
        String random = RandomStringUtils.random(30, true, true);
        //拼接新的文件名
        String fileName = random + "." + suffix;
        //获取当前文件上传的目录
        String path = request.getServletContext().getRealPath("/upload/");
        String filePath = path + fileName;

        try {
            //文件写入
            headImg.transferTo(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}