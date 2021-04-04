package com.java.web;

import com.java.entity.Product;
import com.java.service.ProductService;
import com.java.service.ProductServiceImpl;
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
 * @Date：2021/3/28-20:38
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private ProductService productService;
    private Product product;

    /**
     * 构造器 数据初始化
     */
    public DeleteProductServlet() {
        productService = new ProductServiceImpl();
        product = new Product();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //获取要删除商品对应的编号
        String productIdStr = req.getParameter("productId");
        //数据类型转换
        Integer productId = ConvertUtils.StringConvertInteger(productIdStr);
        //执行删除操作
        int i = productService.deleteProduct(productId);
        if (i > 0) {
            //修改成功，重定向显示所有商品信息
            resp.sendRedirect("showProduct");
        } else {
            //修改失败，跳转到初始修改的servlet
            req.getRequestDispatcher("showProduct").forward(req, resp);
        }
    }
}