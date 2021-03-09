package com.java.wxg.student.bean;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-18:47
 * @Since:jdk1.8
 * @Description:Web教员类
 */
@Data
public class WebTeacher extends Teacher{
    public WebTeacher() {
        setCourseName("Web前端");
    }
}