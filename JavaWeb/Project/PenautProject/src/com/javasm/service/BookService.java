package com.javasm.service;

import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
import com.javasm.entity.Chapter;
import com.javasm.util.PageInfo;

import java.util.List;

/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/12-22:06
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface BookService {
    /**
     * 增
     * @param bookvo
     */
    boolean add(Bookvo bookvo);

    /**
     * 通过id删
     * @param books
     */
    boolean delete(Books books);

    /**
     * 改
     * @param books
     */
    boolean update(Books books);

    /**
     * 查
     * @param books
     * @return
     */
    Books select(Books books);

    /**
     * 根据属性获取图书list
     * @param attribution //attribution：属性 1.男频2.女频3.出版
     * @param start  //    start：分页参数开始位置
     * @param rows //    rows：分页参数行数
     * @return
     */
    List<Bookvo> findBookByAttribution(Integer attribution, Integer start,Integer rows);

    /**
     * 根据bid获取小说章节列表
     * @param bid //花生平台小说ID
     * @param start
     * @param rows
     * @return
     */
    List<Chapter> findChapterByBidByPage(Integer bid, Integer start, Integer rows);

    /**
     * 根据章节id获取小说章节内容
     * @param chapterId
     * @return
     */
    Chapter getChapterContent(Integer chapterId);

    /**
     * 同类相关推荐小说列表
     * @param bid
     * @param start
     * @param rows
     * @return
     */
    List<Bookvo> findBookSimilar(Integer bid, Integer start,Integer rows);


    /**
     * 分页查询
     * @param bookvo
     * @param nowPageStr
     * @param pageNumStr
     * @return
     */
    PageInfo<Bookvo> findAllBookByPage(Bookvo bookvo, String nowPageStr, String pageNumStr);

    /**
     * 根据一级分类查询二级分类
     * @param bookvo
     * @return
     */
    List<Bookvo> findSecondTypeByFirstTypeId(Bookvo bookvo);


    /**
     * 全部一级分类
     *
     * @return
     */
    List<Bookvo> showFirstType();
}
