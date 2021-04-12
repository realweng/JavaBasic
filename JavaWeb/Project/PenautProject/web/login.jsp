<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/27
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <!-- Title and other stuffs -->
    <title>后台登陆页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="">
    <!-- Stylesheets -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="style/font-awesome.css">
    <link href="style/style.css" rel="stylesheet">

    <!-- HTML5 Support for IE -->
    <!--[if lt IE 9]>
    <script src="js/html5shim.js"></script>
    <![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon/favicon.png">
    <style type="text/css">
        body {
            background-image: url(img/login.jpg);
        }
    </style>

</head>

<body>

<!-- Form area -->
<div class="admin-form">
    <div class="container">

        <div class="row">
            <div class="col-md-12">
                <!-- Widget starts -->
                <div class="widget worange">
                    <!-- Widget head -->
                    <div class="widget-head">
                        <i class="icon-lock"></i> 花生娱乐 管理平台
                    </div>

                    <div class="widget-content">
                        <div class="padd">
                            <!-- Login form -->
                                <form class="form-horizontal" action="/adminUser.do?type=adminUserLogin" method="post">
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
                                            <input class="form-control" type="password" name="pwd" placeholder="请输入密码..." required/>
                                        </div>
                                        <div class="col-md-3"></div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3"></label>
                                        <div class="col-md-6">
                                            <button class="btn btn-primary">登录</button>
                                            <a href="#" class="btn btn-danger">注册</a>
                                        </div>
                                        <div class="col-md-3"></div>
                                    </div>
                                </form>
                        </div>
                    </div>

                    <div class="widget-foot">
                        忘记密码了？ <a href="#">点这里</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JS -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>