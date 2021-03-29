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
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/29-19:55
 * @Since:jdk1.8
 * @Description:购物车servlet
 */
@WebServlet("/shopCart")
public class ShoppingCartServlet extends HttpServlet {
    private List<Product> shopCartList;
    private ProductService productService;

    public ShoppingCartServlet() {
        shopCartList = new ArrayList<>(10);
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品ID
        String productIdStr = req.getParameter("productId");
        if (productIdStr.equals("0")) {//从查看购物车的链接跳转到该servlet
            //将数据保持request对象
            req.setAttribute("shopCartList", shopCartList);
            req.getRequestDispatcher("shopCart.jsp").forward(req, resp);//跳转到查看购物车页面
        } else {//从添加到购物车的链接跳转到此servlet
            Integer id = ConvertUtils.StringConvertInteger(productIdStr);
            //通过id查询商品信息
            Product product = productService.findProdcutById(id);
            //存储购物车商品
            shopCartList.add(product);
            resp.sendRedirect("showProduct");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}