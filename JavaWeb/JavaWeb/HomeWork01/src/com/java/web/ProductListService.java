package com.java.web;

import com.java.dao.ProductDao;
import com.java.dao.impl.ProductDaoImpl;
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
 * @Date：2021/4/4-19:51
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/listProduct")
public class ProductListService extends HttpServlet {
    private ProductService productService;

    public ProductListService() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.ListProduct();
        req.setAttribute("products", products);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}