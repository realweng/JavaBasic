<%@ page import="java.util.List" %>
<%@ page import="com.java.entity.Product" %>
<%@ page import="com.java.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/27
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示商品信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1 style="color: sandybrown;">
                <%
                    User userinfo = (User) session.getAttribute("user");
                    out.write(userinfo.getUserName());
                %>，<span style="font-size: 20px">欢迎你！！！</span>
            </h1>
        </div>
    </div>
    <br/>

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <td colspan="7">
                        <a href="saveProduct.jsp" class="btn btn-danger">添加商品</a>
                    </td>
                </tr>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品类型</th>
                    <th>库存数量</th>
                    <th>商品折扣</th>
                    <th>操作</th>
                </tr>

                <%-- 从request中获取list集合,遍历集合 --%>
                <%
                    //获取list
                    List<Product> list = (List<Product>) request.getAttribute("productList");
                    for (Product pro : list) {
                %>
                <tr>
                    <td>
                        <%=pro.getProductId()%>
                    </td>
                    <td>
                        <% out.write(pro.getProductName());%>
                    </td>
                    <td>
                        <%=pro.getProductPrice()%>
                    </td>
                    <td>
                        <%=pro.getTypeId() %>
                    </td>
                    <td>
                        <%=pro.getStockNumber() %>
                    </td>
                    <td>
                        <%=pro.getDiscount() %>
                    </td>
                    <td>
                        <a href="updateProduct.jsp?productId=<%=pro.getProductId()%>" class="btn btn-primary">修改</a>
                        <a href="deleteProduct?productId=<%=pro.getProductId()%>" class="btn btn-default">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
