package com.java.web;

import com.java.dao.ProductDao;
import com.java.dao.impl.ProductDaoImpl;
import com.java.entity.OrderItem;
import com.java.entity.Product;

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
 * @Date：2021/4/4-20:56
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/addOrderItem")
public class OrderItemAddServlet extends HttpServlet {
    private ProductDao productDao;
    private Product product;

    public OrderItemAddServlet() {
        productDao = new ProductDaoImpl();
        product = new Product();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer num = Integer.parseInt(req.getParameter("num"));
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        product = productDao.getProductById(pid);

        OrderItem oi = new OrderItem();

        oi.setNum(num);
        oi.setProduct(product);

        // 在session中存储订单信息
        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");

        if (null == ois) {
            ois = new ArrayList<OrderItem>();
            req.getSession().setAttribute("ois", ois);
        }

        //遍历session中所有的OrderItem
        boolean found = false;
        for (OrderItem orderItem : ois) {
            //如果找到对应的product.id一样的条目，就调整其数量
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                orderItem.setNum(orderItem.getNum() + oi.getNum());
                found = true;
                break;
            }
        }

        //如果没有找到，就新增加一条
        if (!found)
            ois.add(oi);

        resp.sendRedirect("/listOrderItem");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}