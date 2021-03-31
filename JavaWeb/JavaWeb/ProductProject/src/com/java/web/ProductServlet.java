package com.java.web;

import com.java.entity.Product;
import com.java.entity.ProductType;
import com.java.service.ProductService;
import com.java.service.ProductTypeService;
import com.java.service.impl.ProductServiceImpl;
import com.java.service.impl.ProductTypeServiceImpl;
import com.java.util.ConvertUtils;
import com.java.vo.ProductTypeEntity;

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
 * @Date：2021/3/30-20:45
 * @Since:jdk1.8
 * @Description:商品servlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private Product product;
    private ProductTypeService productTypeService;

    /**
     * 构造器 初始化数据
     */
    public ProductServlet() {
        product = new Product();
        productService = new ProductServiceImpl();
        productTypeService = new ProductTypeServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取要处理任务的类型type
        String type = request.getParameter("type");
        switch (type) {
            case "show":
                showProduct(request, response);
                break;
            case "save":
                saveProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "initUpdate":
                initUpdate(request, response);
                break;
            case "initSave":
                initSave(request, response);
                break;
            default:
                //跳转到404
                request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }

    /**
     * 查询所有商品信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取搜索框的内容
        String productName = request.getParameter("productName");
        String typeIdStr = request.getParameter("typeId");
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        product.setProductName(productName);
        product.setTypeId(typeId);
        // 在数据库中联表查询商品信息
        List<ProductTypeEntity> productList = productService.findAllProduct(product);
        // 将商品存储在request对象中
        request.setAttribute("productList", productList);
        List<ProductType> productTypeList = productTypeService.findAllProductType();
        request.setAttribute("productTypeList",productTypeList);
        //跳转到查询页面
        request.getRequestDispatcher("page/product/showAllProduct.jsp").forward(request, response);
    }

    /**
     * 添加商品信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void saveProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        if (i > 0) {
            //添加成功，显示所有商品
            resp.sendRedirect("product?type=show");
        } else {
            //添加失败，重新跳转到添加页面
            req.getRequestDispatcher("page/product/saveProduct.jsp").forward(req, resp);
        }
    }

    /**
     * 获取数据库中有的商品类型
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void initSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductType> productTypeList = productTypeService.findAllProductType();
        req.setAttribute("productTypeList", productTypeList);
        req.getRequestDispatcher("/page/product/saveProduct.jsp").forward(req, resp);
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
        int i = productService.deleteProduct(productId);
        if (i > 0) {
            //修改成功，重定向显示所有商品信息
            resp.sendRedirect("product?type=show");
        } else {
            //修改失败，跳转到初始修改的servlet
            req.getRequestDispatcher("page/product/showAllProduct.jsp").forward(req, resp);
        }
    }

    public void initUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        // 获取商品ID
        String productIdStr = req.getParameter("productId");

        Integer id = ConvertUtils.StringConvertInteger(productIdStr);

        //通过id查询商品信息
        Product product = productService.findProdcutById(id);
        List<ProductType> productTypeList = productTypeService.findAllProductType();

        //将数据保持request对象
        req.setAttribute("product", product);
        req.setAttribute("productTypeList", productTypeList);
        req.getRequestDispatcher("/page/product/updateProduct.jsp").forward(req, resp);
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
            //修改成功，重定向显示所有商品信息
            resp.sendRedirect("product?type=show");
        } else {
            //修改失败，跳转到初始修改的servlet
            req.getRequestDispatcher("/page/product/updateProduct.jsp?productId=" + productId);
        }
    }
}