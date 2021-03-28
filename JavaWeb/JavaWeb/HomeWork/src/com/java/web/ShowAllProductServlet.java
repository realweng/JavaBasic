package com.java.web;

import com.java.entity.Product;
import com.java.service.ProductService;
import com.java.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-19:03
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/showProduct")
public class ShowAllProductServlet extends HttpServlet {
    private ProductService productService;

    /**
     * 构造方法 数据初始化
     */
    public ShowAllProductServlet() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //从数据库中查询所有数据
        List<Product> productList = productService.findAllProduct();
        // 将数据保存到request请求对象中
        req.setAttribute("productList", productList);
        // 从当前的servlet跳转到showAllProduct。jsp中
        req.getRequestDispatcher("showAllProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}