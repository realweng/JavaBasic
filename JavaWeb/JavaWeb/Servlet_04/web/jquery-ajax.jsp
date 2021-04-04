<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
           $("#productName").blur(function (){
               $.ajax({
                   url:"ajax",//提交地址
                   type:"get",//提交方式
                   dataType: "text",// 服务器传递到客户端的数据的格式
                   data: "name=" + $(this).val(),// 从客户端提交到服务器的数据
                   timeout: 3000,// 设置访问时的超时间
                   success:function (data){
                       $("#productNameSpan").html(data);
                   }
               });
           });
        });
    </script>
</head>
<body>
<input type="text" name="productName" id="productName" placeholder="请输入商品名称" >
<span id="productNameSpan" style="color: #ff0000"></span><br/>
</body>
</html>
