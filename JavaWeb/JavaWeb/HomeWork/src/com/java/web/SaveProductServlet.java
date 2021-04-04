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
 * @Date：2021/3/28-18:42
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/saveProduct")
public class SaveProductServlet extends HttpServlet {
    private ProductService productService;
    private Product product;

    /**
     * 构造方法 初始化数据
     */
    public SaveProductServlet() {
        product = new Product();
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");

        //获取请求过来的页面中的商品信息
        String productName = req.getParameter("productName");
        String typeIdStr = req.getParameter("typeId");
        String productPriceStr = req.getParameter("productPrice");
        String stockNumberStr = req.getParameter("stockNumber");
        String discountStr = req.getParameter("discount");

        //类型转换
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        Integer stockNumber = ConvertUtils.StringConvertInteger(stockNumberStr);
        Float productPrice = ConvertUtils.StringConvertFloat(productPriceStr);
        Float discount = ConvertUtils.StringConvertFloat(discountStr);

        //将上面的数据填充到product对象中
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setDiscount(discount);
        product.setStockNumber(stockNumber);
        product.setTypeId(typeId);

        //将数据添加到数据库
        int i = productService.saveProduct(product);
        if(i>0){
            //添加成功，重定向到商品显示页面
            resp.sendRedirect("showProduct");
        }else {
            //添加失败，重新跳转到添加页面
            req.getRequestDispatcher("saveProduct.jsp").forward(req, resp);
        }
    }
}