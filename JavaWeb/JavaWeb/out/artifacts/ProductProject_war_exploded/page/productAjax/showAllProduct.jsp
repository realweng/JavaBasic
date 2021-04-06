<%@ page import="java.util.List" %>
<%@ page import="com.java.entity.Product" %>
<%@ page import="com.java.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示商品信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.js"></script>
    <%--  输入检查  --%>
    <script type="text/javascript" src="../../js/check.js"></script>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        #myFrm td {
            line-height: 40px;
        }

        #showProduct td {
            line-height: 40px;
        }
    </style>

</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h5 style="font-weight: 900">位置：商品列表</h5>
            <input type="hidden" id="countPage">
            <form action="productAjax?type=showProduct" method="post" class="form-horizontal" id="myFrm">
                <table class="table table-bordered table-hover table-striped">
                    <tr>
                        <td class="control-label col-sm-2">
                            商品名称：
                        </td>
                        <td class="col-sm-3">
                            <input type="text" class="form-control" value="${productName }" name="productName">
                            <input type="hidden" name="nowPage" id="nowPage"/>
                        </td>
                        <td class="control-label col-sm-2">
                            商品类型：
                        </td>
                        <td class="col-sm-3">
                            <select class="form-control" name="typeId">
                                <option value="">-- 请选择 --</option>
                                <c:forEach items="${productTypeList}" var="productType">
                                    <option value="${productType.typeId}" ${productType.typeId == typeId?"selected":""}>${productType.typeName }</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="col-sm-2">
                            <button class="btn btn-primary">搜索</button>
                        </td>
                    </tr>
                </table>
            </form>

            <table id="showProduct" class="table table-bordered table-striped table-hover">
                <tr>
                    <td colspan="7">
                        <%--data-toggle="modal" data-target="#myModal"--%>
                        <a class="btn btn-danger" data-toggle="modal" data-target="#myModal">添加商品</a>
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
                <c:forEach items="${pageData.data}" var="product">
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
                            <a name="change" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">修改</a>
                            <a class="btn btn-default" name="delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="7" style="text-align: center">
                        <jsp:include page="../page.jsp"></jsp:include>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div class="row">
        <!-- 添加数据 -->
        <div class="row">
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <!-- 头部 -->
                        <div class="modal-header">
                            <button class="close" data-dismiss="modal" aria-label="Close">x</button>
                            <h2>添加商品</h2>
                        </div>

                        <!-- 主体 -->
                        <div class="modal-body">
                            <!-- 表单（录入商品信息） -->
                            <form class="form-horizontal" id="saveFrm">
                                <div class="form-group row">
                                    <label class="control-label col-sm-4">商品名称：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productName" id="productName"
                                               placeholder="请输入商品名称..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品价格：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productPrice" id="productPrice"
                                               placeholder="请输入商品价格..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>

                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品类型：</label>
                                    <div class="col-sm-5">
                                        <select class="form-control" name="typeId">
                                            <option value="">-- 请选择 --</option>
                                            <c:forEach items="${productTypeList}" var="productType">
                                                <option value="${productType.typeId}" ${productType.typeId == typeId?"selected":""}>${productType.typeName }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品库存：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productNum" id="productNum"
                                               placeholder="请输入商品库存..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品折扣：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="discount" id="discount"
                                               placeholder="请输入商品折扣..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                            </form>
                        </div>

                        <!-- 脚部 -->
                        <div class="modal-footer">
                            <button type="button" id="addProduct" class="btn btn-primary">添加</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="row">
        <!-- 修改数据 -->
        <div class="row">
            <div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <!-- 头部 -->
                        <div class="modal-header">
                            <button class="close" data-dismiss="modal" aria-label="Close">x</button>
                            <h2>修改商品</h2>
                        </div>

                        <!-- 主体 -->
                        <div class="modal-body">
                            <!-- 表单（录入商品信息） -->
                            <form class="form-horizontal" id="updateFrm">
                                <div class="form-group row">
                                    <label class="control-label col-sm-4">商品名称：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productName1" id="productName1"
                                               placeholder="请输入商品名称..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品价格：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productPrice1" id="productPrice1"
                                               placeholder="请输入商品价格..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>

                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品类型：</label>
                                    <div class="col-sm-5">
                                        <select class="form-control" name="typeId1" id="typeId1">
                                            <option value="">-- 请选择 --</option>
                                            <c:forEach items="${productTypeList}" var="productType">
                                                <option value="${productType.typeId}" ${productType.typeId == typeId?"selected":""}>${productType.typeName }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品库存：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="productNum1" id="productNum1"
                                               placeholder="请输入商品库存..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-4">商品折扣：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="discount1" id="discount1"
                                               placeholder="请输入商品折扣..." required="required"/>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                            </form>
                        </div>

                        <!-- 脚部 -->
                        <div class="modal-footer">
                            <button type="button" id="updateProduct" class="btn btn-primary">修改</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>


    </div>

</div>
<script type="text/javascript">
    // 获取当前页面中body的高度
    var bodyHeight = document.body.scrollHeight + 50;
    // 给父级中的iframe设置高度
    var main = parent.document.getElementById("main");
    main.setAttribute("height", bodyHeight);

    $(function () {
        // 给分页中的超链接绑定事件
        $("#pageInfo").children("li").click(function () {
            // 如果li有class=disabled
            var flag = $(this).hasClass("disabled");
            if (!flag) {// 如果flag等于false 就提交表单
                // 获取当前页
                var nowPage = $(this).attr("data-nowPage");
                // 将当前页赋给隐藏域
                $("#nowPage").val(nowPage);
                // 提交表单
                $("#myFrm").submit();
            }
        });
    });

</script>

</body>
</html>
