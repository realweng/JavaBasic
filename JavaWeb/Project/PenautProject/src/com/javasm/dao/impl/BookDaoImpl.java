package com.javasm.dao.impl;

import com.javasm.dao.BookDao;
import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
import com.javasm.entity.Chapter;
import com.javasm.util.JdbcUtil;
import com.javasm.util.PageInfo;

import java.util.List;


/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/12-21:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BookDaoImpl extends BaseDaoImpl<Books>  implements BookDao{


    @Override
    public List<Bookvo> showFirstType() {
        String sql = "SELECT * FROM firsttype;";
        return JdbcUtil.query(sql,Bookvo.class);
    }

    @Override
    public boolean addBook(Bookvo bookvo) {
        String sql = "insert into books VALUES(null,null,?,?,?,?,'url',?,1,null,null); ";
        String sql2 = "UPDATE books set bookId=bid; ";
        return JdbcUtil.update(sql, bookvo.getBookName(), bookvo.getAuthorName(),  bookvo.getSecondTypeId(), bookvo.getDescription(), bookvo.getIsCompletion())>0&&JdbcUtil.update(sql2)>0;
    }

    @Override
    public List<Bookvo> findBookByAttribution(Integer attribution, Integer start, Integer rows) {
        String sql = "SELECT  * FROM books b,firstType f,secondType s WHERE b.secondTypeId=s.secondTypeId and s.firstTypeId=f.firstTypeId and b.state=1 and f.attribution=? limit ?,?;";
        return JdbcUtil.query(sql,Bookvo.class,attribution,start,rows);
    }

    @Override
    public List<Chapter> findChapterByBidByPage(Integer bid, Integer start, Integer rows) {
        String sql = "SELECT  c.* FROM books b,chapter c where b.bookId=c.bookId and b.bid=?  limit ?,?;";
        return JdbcUtil.query(sql,Chapter.class,bid,start,rows);
    }

    @Override
    public Chapter getChapterContent(Integer chapterId) {
        String sql = "SELECT  chaptercontent FROM chapter where chapterId=?;";
        return JdbcUtil.query(sql, Chapter.class).get(0);
    }

    @Override
    public List<Bookvo> findBookSimilar(Integer bid, Integer start, Integer rows) {
        String sql = "SELECT * FROM books b,firstType f,secondType s WHERE b.secondTypeId=s.secondTypeId and s.firstTypeId=f.firstTypeId and b.state=1 and f.firstTypeId=(SELECT s.firstTypeId FROM books b,secondType s WHERE b.secondTypeId=s.secondTypeId and b.state=1 and b.bid=?)  limit ?,?;";
        return JdbcUtil.query(sql,Bookvo.class,bid,start,rows);
    }

    @Override
    public List<Bookvo> findSecondTypeByFirstTypeId(Bookvo bookvo) {
        String sql = "SELECT s.SecondTypeName,s.SecondTypeId FROM secondType s WHERE  s.firstTypeId="+ bookvo.getFirstTypeId()+" ;";
        return JdbcUtil.query(sql,Bookvo.class);
    }

    @Override
    public Integer countBookNumber(Bookvo bookvo) {
        StringBuilder sql = new StringBuilder("SELECT count(1) FROM books b,firstType f,secondType s WHERE b.secondTypeId=s.secondTypeId and s.firstTypeId=f.firstTypeId and b.state=1 ");
        if (bookvo.getBookId()!=null&&!"".equals(bookvo.getBookId())){
            sql.append(" and b.bookId = "+ bookvo.getBookId());
        }
        if (bookvo.getBookName()!=null&&!"".equals(bookvo.getBookName())){
            sql.append(" and b.bookName like '%"+ bookvo.getBookName()+"%' ");
        }
        if (bookvo.getFirstTypeId()!=null){
            sql.append(" and f.firstTypeId ="+ bookvo.getFirstTypeId()+" ");
        }
        if (bookvo.getSecondTypeId()!=null){
            sql.append(" and s.secondTypeId ="+ bookvo.getSecondTypeId()+" ");
        }

        return JdbcUtil.count(sql.toString());
    }

    @Override
    public List<Bookvo> findAllByPage(Bookvo bookvo, PageInfo pageInfo) {
        StringBuilder sql = new StringBuilder("SELECT * FROM books b,firstType f,secondType s WHERE b.secondTypeId=s.secondTypeId and s.firstTypeId=f.firstTypeId and b.state=1 ");
        if (bookvo.getBookId()!=null&&!"".equals(bookvo.getBookId())){
            sql.append(" and b.bookId = "+ bookvo.getBookId()+" ");
        }
        if (bookvo.getBookName()!=null&&!"".equals(bookvo.getBookName())){
            sql.append(" and b.bookName like '%"+ bookvo.getBookName()+"%' ");
        }
        if (bookvo.getFirstTypeId()!=null){
            sql.append(" and f.firstTypeId ="+ bookvo.getFirstTypeId()+" ");
        }
        if (bookvo.getSecondTypeId()!=null){
            sql.append(" and s.secondTypeId ="+ bookvo.getSecondTypeId()+" ");
        }
        sql.append(" limit "+pageInfo.getStartIndex()+","+pageInfo.getPageNum());

        return JdbcUtil.query(sql.toString(),Bookvo.class);
    }
}