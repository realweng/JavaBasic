<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/6
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getContextPath(); %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
<form action="<%=basePath%>/upload" method="post" enctype="multipart/form-data">
    头像 : <input name="headImg" type="file"><br>
    昵称 : <input name="nickname" type="text"><br>
    <button>提交</button>
</form>
</body>
</html>
