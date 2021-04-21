package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/12-21:21
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookvo {

    private Integer bid;//    bid int primary key auto_increment, -- 花生图书统一id
    private Integer bookId;//    bookId int unique , -- 第三方图书id
    private String bookName;//   书名
    private String authorName;//   作者
    private Integer attribution;//属性 1、男频		2、女频		3、出版
    private Integer firstTypeId;//    firstTypeId int,-- 一级分类id
    private Integer secondTypeId;//    secondTypeId int,-- 二级分类id
    private String firstTypeName;//  一级分类名称
    private String secondTypeName;//  二级分类名称
    private String description;//    description varchar(500), -- 书籍描述
    private String coverUrl;//    coverUrl varchar(100), -- 封面图片路径
    private Integer isCompletion;//    isCompletion int, -- 状态 1、连载		0、完结
    private Integer state;//    state int  -- 状态 1、正常		0、下架

    public Bookvo(String bookName, String authorName, int firstTypeId, int secondTypeId, String description, String coverUrl, int isCompletion, int state) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.firstTypeId = firstTypeId;
        this.secondTypeId = secondTypeId;
        this.description = description;
        this.coverUrl = coverUrl;
        this.isCompletion = isCompletion;
        this.state = state;
    }
}
