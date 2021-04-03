<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原生Ajax</title>
    <script type="text/javascript">
        function checkName() {
            // 获取productname的value
            var productName = document.getElementById("productName").value;
            // 通过XMLHttpRequest对象向服务器发送请求
            // 1.创建XMLHttpRequest对象
            var httpRequest = new XMLHttpRequest();
            // 2.设置请求的信息
            httpRequest.open("post", "ajax");
            // 3.设置content-type
            httpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            // 4.发送请求到服务器,如果是post提交，需要传递数据是放在send方式中。"key=value&key=value"
            httpRequest.send("name=" + productName);
            // 5.设置回调函数，处理服务器的数据
            httpRequest.onreadystatechange = function () {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    alert(httpRequest.responseText);
                }
            }
        }
        </script>
</head>
<body>
        <%--  实现验证商品名称是否重复 --%>
        <input type="text" name="productName" id="productName" placeholder="请输入商品名称" value="${name}" onblur="checkName()">
        <span id="productNameSpan" style="color: red"></span><br/>
        <input type="text" name="productPrice" id="productPrice" placeholder="请输入商品价格">
      <br/>
        <button>添加</button>
</body>
</html>
