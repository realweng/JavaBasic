<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示商品信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form action="product?type=show" method="post" class="form-horizontal" id="myFrm">
                <table class="table table-bordered table-hover table-striped">
                    <tr>
                        <td class="control-label col-sm-2">
                            商品名称：
                        </td>
                        <td class="col-sm-3">
                            <input type="text" class="form-control" value="${productName}" name="productName">
                            <input type="hidden" name="nowPage" id="nowPage"/>
                            <input type="hidden" name="nowPage1" id="nowPage1"/>
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
<%--                        <td class="col-sm-1">--%>
<%--                            <select class="form-control" style="margin: 5px" name="pageNum" id="pageNum">--%>
<%--                                <option value="3" ${pageNum == 3?"selected":""}>3</option>--%>
<%--                                <option value="6" ${pageNum == 6?"selected":""}>6</option>--%>
<%--                                <option value="9" ${pageNum == 9?"selected":""}>9</option>--%>
<%--                            </select>--%>
<%--                        </td>--%>
                        <td class="col-sm-2">
                            <button class="btn btn-primary">搜索</button>
                        </td>
                    </tr>
                </table>
            </form>

            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <td colspan="7">
                        <a href="/product?type=initSave" class="btn btn-danger">添加商品</a>
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
                            <a href="/product?productId=${product.productId}&type=initUpdate"
                               class="btn btn-primary">修改</a>
                            <a href="/product?productId=${product.productId}&type=delete" class="btn btn-default">删除</a>
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
</div>
<script type="text/javascript">
    // 获取当前页面中body的高度
    var bodyHeight = window.document.body.offsetHeight;
    console.log(bodyHeight);
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
                var options = $("#pageNum option:selected");
                $("#nowPage1").val(options.val());
                $("#pageNum").val(options.val());
                // 提交表单
                $("#myFrm").submit();
            }
        });
    });

    // $("#pageNum").change(function (){
    //     var options = $("#pageNum option:selected");
    //     $("#nowPage1").val(options.val());
    //     $("#myFrm").submit();
    // });

</script>
</body>
</html>
