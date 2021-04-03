<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原生态的ajax</title>
    <script type="text/javascript">
        function checkName() {
            // 获取productname的value
            var productName = document.getElementById("productName").value;

            // 通过XMLHttpRequest对象向服务器发送请求

            // 1.实例化XMLHttpRequest
            var httpRequst = new XMLHttpRequest();
            // 2.设置请求到服务器的信息（提交地址，提交方式）
            httpRequst.open("get", "ajax?name=" + productName);
            // 3.发送请求
            httpRequst.send();
            // 4.通过回调函数接收到由服务器传递到客户端的数据
            // httpRequst.onreadystatechange(callBack);
            httpRequst.onreadystatechange = function () {
                // alert("请求过程的状态：" + httpRequst.readyState);// 请求过程的状态
                // alert("响应的状态：" + httpRequst.status);// 响应的状态
                // alert("服务器传递的数据：" + httpRequst.responseText);// 有服务器发送到客户端的数据
                if (httpRequst.status == 200 && httpRequst.readyState == 4) {
                    document.getElementById("productNameSpan").innerText = httpRequst.responseText;
                }
            }

        }

        // function callBack(){
        //
        // }

    </script>
</head>
<body>
<%--  实现验证商品名称是否重复 --%>
<input type="text" name="productName" id="productName" placeholder="请输入商品名称" value="${name}" onblur="checkName()">
<span id="productNameSpan" style="color: red"></span><br/>
<input type="text" name="productPrice" id="productPrice" placeholder="请输入商品价格">
</span><br/>
<button>添加</button>
</body>
</html>

