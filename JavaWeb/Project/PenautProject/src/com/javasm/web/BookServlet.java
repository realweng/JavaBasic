package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.entity.Books;
import com.javasm.entity.Bookvo;
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
