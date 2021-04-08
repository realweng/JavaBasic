<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/27
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="../../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#productPrice").blur(function () {
                var reg = /^(\d+(\.\d+)?|\d+)$/;
                var productPriceValue = $(this).val();
                if (!reg.test(productPriceValue)) {
                    $(this).parent().next("div").html("价格输入，请输入数字!").css("color", "red");
                } else {
                    $(this).parent().next("div").html("");
                }
            });

            $("#productNums").blur(function () {
                var reg = /^\d+$/;
                var productNumsValue = $(this).val();
                if (!reg.test(productNumsValue)) {
                    $(this).parent().next("div").html("数量输入，请输入数字!").css("color", "red");
                } else {
                    $(this).parent().next("div").html("");
                }
            });

            $("#productDiscount").blur(function () {
                var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
                var productDiscount = $(this).val();
                if (!reg.test(productDiscount)) {
                    $(this).parent().next("div").html("折扣输入，请输入0-1的数字").css("color", "red");
                } else {
                    $(this).parent().next("div").html("");
                }
            });

            $("#myFrm").submit(function () {

                var reg = /^(\d+(\.\d+)?|\d+)$/;
                var productPriceValue = $("#productPrice").val();
                if (!reg.test(productPriceValue)) {
                    $("#productPrice").parent().next("div").html("价格输入有误，请输入数字!").css("color", "red");
                    return false;// 防止表单提交
                } else {
                    $("#productPrice").parent().next("div").html("");
                }

                var reg = /^\d+$/;
                var stockNumberValue = $("#productNums").val();
                if (!reg.test(stockNumberValue)) {
                    $("#productNums").parent().next("div").html("数量输入有误，请输入数字!").css("color", "red");
                    return false;// 防止表单提交
                } else {
                    $("#productNums").parent().next("div").html("");
                }

                var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
                var productDiscount = $("#productDiscount").val();
                if (!reg.test(productDiscount)) {
                    $("#productDiscount").parent().next("div").html("1折扣输入，请输入0-1的数字").css("color", "red");
                    return false;// 防止表单提交
                } else {
                    $("#productDiscount").parent().next("div").html("");
                }
                return true;//提交表单
            });

        });

    </script>
</head>
<body>
<div class="container">
    <h5 style="font-weight: 900">位置：商品列表 --> 添加商品</h5>
    <br/>
    <form id="myFrm" action="/product.do?type=save" method="post" class="form-horizontal">
        <div class="row">
            <div class="form-group">
                <label class="control-label col-sm-3"> 商品名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="productName" placeholder="请输入商品名称..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-sm-3">商品类型：</label>
                <div class="col-sm-5">
                    <select class="form-control" name="typeId">
                        <c:forEach items="${productTypeList}" var="type">
                            <option value="${type.typeId}">${type.typeName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group">
                <label class="control-label col-sm-3"> 商品价格：</label>
                <div class="col-sm-5">
                    <input id="productPrice" type="text" class="form-control" name="productPrice"
                           placeholder="请输入商品价格..."
                           required="required" maxlength="12"/>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-sm-3"> 商品数量：</label>
                <div class="col-sm-5">
                    <input id="productNums" type="text" class="form-control" name="stockNumber" placeholder="请输入商品数量..."
                           required="required" maxlength="12"/>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-sm-3"> 商品折扣：</label>
                <div class="col-sm-5">
                    <input id="productDiscount" type="text" class="form-control" name="discount"
                           placeholder="请输入商品折扣..."
                           required="required" maxlength="12"/>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="col-sm-3"></label>
                <div class="col-sm-5">
                    <button type="submit" class="btn btn-primary">保存</button>
                    <button type="reset" class="btn btn-danger">重置</button>
                </div>
            </div>
        </div>

    </form>
</div>
</body>
</html>
