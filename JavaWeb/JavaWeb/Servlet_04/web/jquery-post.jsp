<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#productName").blur(function () {
                $.post("ajax", "name=" + $(this).val(), function (data) {
                    $("#productNameSpan").html(data);
                }, "text");
            });

        });
    </script>
</head>
<body>
<input type="text" name="productName" id="productName" placeholder="请输入商品名称">
<span id="productNameSpan" style="color: red"></span><br/>
</body>
</html>
