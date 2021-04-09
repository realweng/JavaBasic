<%@ page import="com.java.entity.Product" %>
<%@ page import="com.java.util.ConvertUtils" %>
<%@ page import="com.java.service.ProductService" %>
<%@ page import="ProductServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/27
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <form action="updateProduct" method="post" class="form-horizontal">
        <%
            Product pro = (Product) request.getAttribute("product");
        %>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品名称：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" value="<%=pro.getProductName()%>" name="productName"
                           placeholder="请输入商品名称..."
                           required="required" maxlength="12"/>
                    <input type="hidden" value="<%=pro.getProductId()%>" name="productId"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4">商品类型：</label>
                <div class="col-md-8">
                    <select class="form-control" name="typeId">
                        <% String flag = pro.getTypeId() == 1 ? "selected" : ""; %>
                        <option value="1"  <%=flag%> >生活类
                        </option>
                        <% flag = pro.getTypeId() == 2 ? "selected" : ""; %>
                        <option value="2"  <%=flag%> >零食类</option>
                        <% flag = pro.getTypeId() == 3 ? "selected" : ""; %>
                        <option value="3"  <%=flag%> >美妆类</option>
                        <% flag = pro.getTypeId() == 4 ? "selected" : ""; %>
                        <option value="4"  <%=flag%> >电子产品</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品价格：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" value="<%=pro.getProductPrice()%>" name="productPrice"
                           placeholder="请输入商品价格..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品数量：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" value="<%=pro.getStockNumber()%>" name="stockNumber"
                           placeholder="请输入商品数量..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品折扣：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" value="<%=pro.getDiscount()%>" name="discount"
                           placeholder="请输入商品折扣..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="col-md-4"></label>
                <div class="col-md-8">
                    <button type="submit" class="btn btn-primary">保存</button>
                    <button type="reset" class="btn btn-danger">重置</button>
                </div>
            </div>
        </div>

    </form>
</div>
</body>
</html>
