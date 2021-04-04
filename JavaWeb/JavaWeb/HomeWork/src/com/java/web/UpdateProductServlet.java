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
 * @Date：2021/3/28-19:04
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    private ProductService productService;
    private Product product;

    /**
     * 构造器 数据初始化
     */
    public UpdateProductServlet() {
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
        //获取请求页面的商品信息
        String productName = req.getParameter("productName");
        String typeIdStr = req.getParameter("typeId");
        String productPriceStr = req.getParameter("productPrice");
        String stockNumberStr = req.getParameter("stockNumber");
        String discountStr = req.getParameter("discount");
        String productIdStr = req.getParameter("productId");

        //数据类型转换
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        Integer stockNumber = ConvertUtils.StringConvertInteger(stockNumberStr);
        Float productPrice = ConvertUtils.StringConvertFloat(productPriceStr);
        Float discount = ConvertUtils.StringConvertFloat(discountStr);
        Integer productId = ConvertUtils.StringConvertInteger(productIdStr);

        //将数据存入product对象
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setDiscount(discount);
        product.setStockNumber(stockNumber);
        product.setTypeId(typeId);
        product.setProductId(productId);

        //在数据库中执行修改
        int i = productService.updateProduct(product);
        if (i > 0) {
            //修改成功 重定向
            resp.sendRedirect("showProduct");
        } else {
            //修改失败，跳转到初始修改的servlet
            req.getRequestDispatcher("updateProduct.jsp?productId=" + productId);
        }
    }
}