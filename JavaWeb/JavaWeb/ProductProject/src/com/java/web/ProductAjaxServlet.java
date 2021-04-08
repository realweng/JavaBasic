package com.java.web;

import com.alibaba.fastjson.JSONObject;
import com.java.entity.Product;
import com.java.entity.ProductType;
import com.java.service.ProductService;
import com.java.service.ProductServiceImpl;
import com.java.service.ProductTypeService;
import com.java.service.ProductTypeServiceImpl;
import com.java.util.ConvertUtils;
import com.java.util.PageInfo;
import com.java.vo.ProductTypeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/5-15:46
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/productAjax.do")
public class ProductAjaxServlet extends HttpServlet {
    private ProductService productService;
    private ProductTypeService productTypeService;
    private Product product;
    public ProductAjaxServlet() {
        productService = new ProductServiceImpl();
        productTypeService = new ProductTypeServiceImpl();
        product = new Product();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String type = req.getParameter("type");
        switch (type) {
            case "showProduct":
                showProduct(req, resp);
                break;
            case "saveProduct":
                saveProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
            case "initUpdate":
                initUpdate(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                resp.sendRedirect("404.jsp");
        }
    }

    /**
     * 查询所有的商品信息
     *
     * @param request
     * @param response
     */
    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String typeIdStr = request.getParameter("typeId");

        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");

        product.setTypeId(ConvertUtils.StringConvertInteger(typeIdStr));
        product.setProductName(productName);

        PageInfo<ProductTypeEntity> pageInfo = productService.findAllProductByPage(product, nowPage, pageNum);

        request.setAttribute("pageData", pageInfo);

        //  调用查询商品类型的service方法
        List<ProductType> productTypeList = productTypeService.findAllProductType();
        //  将productTYpeList保存到request作用域中
        request.setAttribute("productTypeList", productTypeList);

        request.getRequestDispatcher("page/productAjax/showAllProduct.jsp").forward(request, response);
    }

    /**
     * 添加商品
     *
     * @param request
     * @param response
     */
    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取商品信息
        String productName = request.getParameter("productName");
        String typeIdStr = request.getParameter("typeId");
        String productPriceStr = request.getParameter("productPrice");
        String stockNumberStr = request.getParameter("productNum");
        String discountStr = request.getParameter("discount");

        // 将数据封装到product对象中
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        Integer stockNumber = ConvertUtils.StringConvertInteger(stockNumberStr);
        Float productPrice = ConvertUtils.StringConvertFloat(productPriceStr);
        Float discount = ConvertUtils.StringConvertFloat(discountStr);

        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setStockNumber(stockNumber);
        product.setTypeId(typeId);
        product.setDiscount(discount);
        // 添加商品
        int flag = 0;
        flag = productService.saveProduct(product);

        String message = flag > 0 ? "添加成功" : "添加失败";

        PrintWriter out = response.getWriter();
        out.write(message);
        out.flush();
        out.close();
    }

    public void initUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String productIdStr = req.getParameter("productId");
        Integer productId = ConvertUtils.StringConvertInteger(productIdStr);

        product = productService.findProdcutById(productId);
        String message = JSONObject.toJSONString(product);

        PrintWriter out = resp.getWriter();
        out.write(message);
        out.flush();
        out.close();
    }

    /**
     * 更新商品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void updateProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

        //获取请求页面的商品信息
        String productName = req.getParameter("productName1");
        String typeIdStr = req.getParameter("typeId1");
        String productPriceStr = req.getParameter("productPrice1");
        String stockNumberStr = req.getParameter("productNum1");
        String discountStr = req.getParameter("discount1");
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
        int flag = 0;
        flag = productService.updateProduct(product);
        String message = flag > 0 ? "修改成功" : "修改失败";
        PrintWriter out = resp.getWriter();
        out.write(message);
        out.flush();
        out.close();
    }

    /**
     * 删除商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

        //获取要删除商品对应的编号
        String productIdStr = req.getParameter("productId");
        //数据类型转换
        Integer productId = ConvertUtils.StringConvertInteger(productIdStr);
        //执行删除操作
        int flag = 0;
        flag = productService.deleteProduct(productId);
        String message = flag > 0 ? "删除成功" : "删除失败";
        PrintWriter out = resp.getWriter();
        out.write(message);
        out.flush();
        out.close();
    }
}