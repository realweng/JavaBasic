<%@ page import="com.java.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/29
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 导入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车展示页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h1 style="color: sandybrown;">
                    购物车列表
                </h1>
            </div>
        </div>
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <td colspan="6">
                        <a href="showProduct" class="btn btn-danger">返回商品页</a>
                    </td>
                </tr>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品类型</th>
                    <th>库存数量</th>
                    <th>商品折扣</th>
                </tr>

                <c:forEach items="${shopCartList}" var="pro">
                    <tr>
                        <td>
                                ${pro.productId}
                        </td>
                        <td>
                                ${pro.productName}
                        </td>
                        <td>
                                ${pro.productPrice}
                        </td>
                        <td>
                                ${pro.typeId}
                        </td>
                        <td>
                                ${pro.stockNumber}
                        </td>
                        <td>
                                ${pro.discount}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
