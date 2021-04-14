<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功测试页面</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <!-- Stylesheets -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="style/font-awesome.css">
    <link href="style/style.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            $("#updatePwd").click(function () {
                // 获取form表单中的数据
                var formData = $("#updatePwdFrm").serialize();
                console.log(formData);

                //  使用.post请求服务器完成添加
                $.post("adminUser.do", "type=updatePassword&" + formData, function (data) {
                    alert(data);
                });
            });
        });
    </script>
</head>
<body>
<h1>登录成功</h1><br/>
<a href="/adminUser.do?type=adminUserLogout">退出登录</a><br/>

<form class="form-horizontal" id="updatePwdFrm">
    <div class="form-group row">
        <label class="control-label col-sm-4">账号：</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" name="userName" id="userName"
                   placeholder="请输入用户名..." required="required"/>
        </div>
        <div class="col-sm-3"></div>
    </div>
    <div class="form-group row">
        <label class="control-label col-sm-4">旧密码：</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" name="pwd" id="pwd"
                   placeholder="请输入旧密码..." required="required"/>
        </div>
        <div class="col-sm-3"></div>
    </div>
    <div class="form-group row">
        <label class="control-label col-sm-4">新密码：</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" name="newPwd" id="newPwd"
                   placeholder="请输入新密码..." required="required"/>
        </div>
        <div class="col-sm-3"></div>
    </div>
</form>
<input type="submit" id="updatePwd"/>
</body>
</html>
