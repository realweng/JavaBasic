<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        .container {
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="register" method="post" class="form-horizontal">
        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4"> 账号：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="userName" placeholder="请输入账号..."
                           required="required" maxlength="12"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">密码：</label>
                <div class="col-md-8">
                    <input type="password" class="form-control" name="pwd" placeholder="请输入密码..."
                           required="required" maxlength="18"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">确认密码：</label>
                <div class="col-md-8">
                    <input type="password" class="form-control" placeholder="请输入确认密码..."
                           required="required" maxlength="18"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">性别：</label>
                <div class="col-md-8">
                    <div class="radio">
                        <label>
                            <input type="radio" value="男" name="sex" placeholder="请输入确认密码..."
                                   required="required" maxlength="18" checked="checked"/>男
                        </label>
                        <label>
                            <input type="radio" value="女" name="sex" placeholder="请输入确认密码..."
                                   required="required" maxlength="18"/>女
                        </label>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">爱好：</label>
                <div class="col-md-8">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="睡觉" checked="checked" name="aihao"/>睡觉
                        </label>
                        <label>
                            <input type="checkbox" value="LOL" name="aihao"/>LOL
                        </label>
                        <label>
                            <input type="checkbox" value="编程" name="aihao"/>编程
                        </label>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">地址：</label>
                <div class="col-md-8">
                    <select class="form-control" name="address">
                        <option value="湖北省">湖北省</option>
                        <option value="四川省">四川省</option>
                        <option value="贵州省">贵州省</option>
                        <option value="山西省">山西省</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="control-label col-md-4">图像：</label>
                <div class="col-md-8">
                    <input type="file" name="myFile"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4 col-md-offset-4">
                <label class="col-md-4"></label>
                <div class="col-md-8">
                    <button type="submit" class="btn btn-primary">注册</button>
                    <button type="reset" class="btn btn-danger">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
