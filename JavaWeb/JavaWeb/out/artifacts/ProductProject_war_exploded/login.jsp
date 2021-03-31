<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/27
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background-color: pink;
            background-image: url("img/2.jpg");
        }

        #loginDiv {
            border: 1px silver solid;
            margin-top: 200px;
            padding-top: 90px;
            background-color: lightyellow;
            height: 300px;
            /* 设置弧度 */
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" id="loginDiv">

            <!--
                action：完成登录的Servlet的url
                action="login" ：相对路径，加上当页面之上的文件夹（不包括web）
                action="/login"：绝对路劲，从项目根目录开始访问

                action="login" 访问到servlet  ==>  修改servlet 的 url
            -->
            <form class="form-horizontal" action="login" method="post">

                <div class="form-group">
                    <label class="control-label col-md-3">账号：</label>
                    <div class="col-md-6">
                        <input class="form-control" type="text" name="userName" placeholder="请输入账号..." required/>
                    </div>
                    <div class="col-md-3">
                        ${message}
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">密码：</label>
                    <div class="col-md-6">
                        <input class="form-control" type="password" name="pwd" placeholder="请输入账号..." required/>
                    </div>
                    <div class="col-md-3"></div>
                </div>


                <div class="form-group">
                    <label class="control-label col-md-3"></label>
                    <div class="col-md-6">
                        <button class="btn btn-primary">登录</button>
                        <a href="register.jsp" class="btn btn-danger">注册</a>
                    </div>
                    <div class="col-md-3"></div>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>