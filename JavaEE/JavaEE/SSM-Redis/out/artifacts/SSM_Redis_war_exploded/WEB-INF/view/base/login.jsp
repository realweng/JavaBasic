<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/10
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<% String basePath = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>
</head>
<body>
<form action="<%=basePath%>/login" method="post">
    用户名 : <input name="username"> <br>
    密码 : <input name="password" type="password"><br>
    <button>登录</button>
</form>
</body>
</html>
