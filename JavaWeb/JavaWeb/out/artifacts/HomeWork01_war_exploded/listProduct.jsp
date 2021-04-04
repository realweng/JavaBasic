<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("input.addCartButton").removeAttr("disabled");//移除禁止点击
            $("input.addCartButton").click(function(){
                $(this).attr("disabled","disabled"); //点击后当前按钮设置为不可点击状态
                var button = $(this);
                var pid = $(this).attr("pid");
                var number = $("input.number[pid="+pid+"]").val();
                var page = "/addOrderItem";
                $.get(
                    page,
                    {"num":number,"pid":pid},
                    function(result){
                        $("#addCartSuccessMessage").fadeIn(1200);
                        $("#addCartSuccessMessage").fadeOut(1200,function(){
                            button.removeAttr("disabled") ;
                        });
                    }
                );

            });
            $("#addCartSuccessMessage").hide();
        });
    </script>
</head>
<body>
<c:if test="${!empty user}">
    <div align="center">
        当前用户: ${user.name}
    </div>
</c:if>
<div  align="center" style="height:20px;margin:20px;" >
    <span style="color:Chartreuse" id="addCartSuccessMessage">加入购物车成功</span>
</div>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                数量<input pid="${product.id}" class="number" type="text" value="1" name="num">
                <input class="addCartButton" pid="${product.id}" type="submit" value="加入购物车">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/listOrderItem">查看购物车</a></td>
    </tr>
</table>
</body>
</html>
