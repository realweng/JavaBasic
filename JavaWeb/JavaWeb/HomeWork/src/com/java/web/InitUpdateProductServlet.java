package com.java.web;

import com.java.entity.Product;
import com.java.service.ProductService;
import com.java.service.impl.ProductServiceImpl;
import com.java.util.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-17:56
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/initUpdate")
public class InitUpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品ID
        String productIdStr = req.getParameter("productId");

        Integer id = ConvertUtils.StringConvertInteger(productIdStr);

        //通过id查询商品信息
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProdcutById(id);

        //将数据保持request对象
        req.setAttribute("product", product);
        req.getRequestDispatcher("updateProduct.jsp").forward(req, resp);
    }
}
