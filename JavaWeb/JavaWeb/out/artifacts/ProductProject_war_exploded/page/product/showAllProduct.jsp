<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示商品信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <td colspan="7">
                        <a href="page/product/saveProduct.jsp" class="btn btn-danger">添加商品</a>
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
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>
                                ${product.productId}
                        </td>
                        <td>
                                ${product.productName}
                        </td>
                        <td>
                                ${product.productPrice}
                        </td>
                        <td>
                                ${product.typeName}
                        </td>
                        <td>
                                ${product.stockNumber}
                        </td>
                        <td>
                                ${product.discount}
                        </td>
                        <td>
                            <a href="/product?productId=${product.productId}&type=init" class="btn btn-primary">修改</a>
                            <a href="/product?productId=${product.productId}&type=delete" class="btn btn-default">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
