<%--
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

    <form action="saveProduct" method="post" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品名称：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="productName" placeholder="请输入商品名称..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4">商品类型：</label>
                <div class="col-md-8">
                    <select class="form-control" name="typeId">
                        <option value="1">生活类</option>
                        <option value="2">零食类</option>
                        <option value="3">美妆类</option>
                        <option value="4">电子产品</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品价格：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="productPrice" placeholder="请输入商品价格..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品数量：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="stockNumber" placeholder="请输入商品数量..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-6">
                <label class="control-label col-md-4"> 商品折扣：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="discount" placeholder="请输入商品折扣..."
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
