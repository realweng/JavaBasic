package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
import com.javasm.entity.Chapter;
import com.javasm.service.BookService;
import com.javasm.service.impl.BookServiceImpl;
import com.javasm.util.PageInfo;
import com.javasm.util.RequestDataConvert;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author：Yp
 * @Version：1.0
 * @Date：2021/4/13-22:27
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/bookServlet.do")
public class BookServlet extends BaseServlet<Bookvo> {

    BookService bookService = new BookServiceImpl();
    Bookvo bookvo = new Bookvo();
    Books books =new Books();
    PageInfo pageInfo = new PageInfo();

    public String findBookByPage(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        bookvo = RequestDataConvert.convertToEntityByField(Bookvo.class,request);
        pageInfo = RequestDataConvert.convertToEntityByField(PageInfo.class,request);
        PageInfo<Bookvo> bookPageInfo = bookService.findAllBookByPage(bookvo,pageInfo.getNowPage().toString(),pageInfo.getPageNum().toString());
        String jsonString = JSONObject.toJSONString(bookPageInfo);
        message = "a:"+jsonString;
        return message;
    }

    public String findBookByAttribution(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        String attribution = request.getParameter("attribution");
        String start = request.getParameter("start");
        String rows = request.getParameter("rows");
        List<Bookvo> bookByAttribution = bookService.findBookByAttribution(Integer.valueOf(attribution), Integer.valueOf(start), Integer.valueOf(rows));
        String jsonString = JSONObject.toJSONString(bookByAttribution);
        message = "a:"+jsonString;
        return message;
    }

    public String findBookByBid(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        books = RequestDataConvert.convertToEntityByField(Books.class,request);//从request中取得bid
        Books books = bookService.select(this.books);
        String jsonString = JSONObject.toJSONString(books);
        message = "a:"+jsonString;
        return message;
    }

    public String findChapterByBidByPage(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        String bid = request.getParameter("bid");
        String start = request.getParameter("start");
        String rows = request.getParameter("rows");
        List<Chapter> chapterByBidByPage = bookService.findChapterByBidByPage(Integer.valueOf(bid), Integer.valueOf(start), Integer.valueOf(rows));
        String jsonString = JSONObject.toJSONString(chapterByBidByPage);
        message = "a:"+jsonString;
        return message;
    }

    public String getChapterContent(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        String uid = request.getParameter("uid");//        Long uid 用户id
        String isvip = request.getParameter("isvip");//        Boolean isvip 是否收费:1收费 0免费
        String chapterid = request.getParameter("chapterid");//        Integer chapterid 第三方小说章节id
        if (Integer.valueOf(uid)==2222&&Integer.valueOf(isvip)==0){
            Chapter chapter = bookService.getChapterContent(Integer.valueOf(chapterid));
            String jsonString = JSONObject.toJSONString(chapter);
            message = "a:"+jsonString;
        }
        return message;
    }

    public String findBookSimilar(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        String bid = request.getParameter("bid");
        String start = request.getParameter("start");
        String rows = request.getParameter("rows");
        List<Bookvo> bookSimilar = bookService.findBookSimilar(Integer.valueOf(bid), Integer.valueOf(start), Integer.valueOf(rows));
        String jsonString = JSONObject.toJSONString(bookSimilar);
        message = "a:"+jsonString;
        return message;
    }


    public String findSecondTypeByFirstTypeId(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        bookvo = RequestDataConvert.convertToEntityByField(Bookvo.class,request);
        List<Bookvo> books = bookService.findSecondTypeByFirstTypeId(this.bookvo);
        String jsonString = JSONObject.toJSONString(books);
        message = "a:"+jsonString;
        return message;
    }

    public String showFirstType(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        List<Bookvo> books = bookService.showFirstType();
        String jsonString = JSONObject.toJSONString(books);
        message = "a:"+jsonString;
        return message;
    }

    public String addBook(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        bookvo = RequestDataConvert.convertToEntityByField(Bookvo.class,request);
        boolean add = bookService.add(bookvo);
        if (add){
            message = "a:添加成功";
        }
        return message;
    }

    public String updateBook(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        books = RequestDataConvert.convertToEntityByField(Books.class,request);
        boolean updata = bookService.update(books);
        if (updata){
            message = "a:修改成功";
        }
        return message;
    }

    public String removeBook(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String message = "";
        books = RequestDataConvert.convertToEntityByField(Books.class,request);
        boolean updata = bookService.delete(books);
        if (updata){
            message = "a:删除成功";
        }
        return message;
    }

}
