package com.java.web;

import com.java.entity.OrderItem;

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
 * @Date：2021/4/4-21:33
 * @Since:jdk1.8
 * @Description:删除选中的商品
 */
@WebServlet("/deleteOrderItem")
public class OrderItemDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");
        List<OrderItem> ois4Delete =new ArrayList<>();//存放要删除的购物车商品
        if(null!=ois){
            for (OrderItem io : ois) {
                if(io.getProduct().getId()==pid){
                    ois4Delete.add(io);
                }
            }
        }
        ois.removeAll(ois4Delete);
        resp.sendRedirect("/listOrderItem");
    }
}