package com.javasm.service;

import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
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
