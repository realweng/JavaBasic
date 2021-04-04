<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form action="login" method="post">
    账号： <input type="text" name="name"> <br>
    密码： <input type="password" name="password"> <br>
    <input type="submit" value="登录">
  </form>
  </body>
</html>
