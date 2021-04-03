<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      // 获取输入框中的内容
      var productName = document.getElementById("productName");
      // 发送请求到服务器
      // location.href = "checkName?name=" + productName;
    </script>
  </head>
  <body>
  <%--  实现验证商品名称是否重复 --%>
  <input type="text" name="productName" id="productName" placeholder="请输入商品名称" value="${name}" onblur="checkName()">
  <span id="productNameSpan" style="color: #ff0000">${message}</span><br/>
  <input type="text" name="productPrice" id="productPrice" placeholder="请输入商品价格">
  <br/>
  <button>添加</button><br />
  <a href="ajax-post.jsp">ajax-post</a><br/>
  <a href="ajax-get.jsp">ajax-get</a>
  </body>
</html>
