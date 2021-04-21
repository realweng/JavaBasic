package com.javasm.dao;

import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
import com.javasm.util.PageInfo;

import java.util.List;

/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/12-21:03
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface BookDao extends BaseDao<Books>{
    /**
     * 分页查询
     * @param bookvo
     * @param pageInfo
     * @return
     */
    List<Bookvo> findAllByPage(Bookvo bookvo, PageInfo pageInfo);

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

    boolean addBook(Bookvo bookvo);

    public Integer countBookNumber(Bookvo bookvo);
}
