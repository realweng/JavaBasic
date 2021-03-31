<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/30
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理系统</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }
    </style>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<div class="container">

    <%--  头部 --%>
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#nav-content" aria-expanded="false">
                        <!-- <span class="sr-only">Toggle navigation</span> -->
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="#">商品管理系统</a>
                </div>

                <div class="collapse navbar-collapse" id="nav-content">

                    <!-- 右边菜单 -->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a>
                                <img src="img/stick.gif" class="img-circle" width="18px" height="18px"/>
                            </a>
                        </li>
                        <li><a>${user.userName},欢迎你</a></li>
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false">个人中心<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a>查看个人信息</a></li>
                                <li><a>修改密码</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a>登出</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </nav>
        </div>
    </div>

    <%-- 主题内容和导航 --%>
    <div class="row">

        <%-- 导航 --%>
        <div class="col-md-3">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne"
                               aria-expanded="true" aria-controls="collapseOne">
                                系统管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingOne">
                        <div class="panel-body">
                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a>数据初始化</a>
                                </li>
                                <li class="list-group-item">
                                    <a>修改配置信息</a>
                                </li>
                                <li class="list-group-item">
                                    <a>修改主页</a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                角色管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">

                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <%-- data-url：自定义属性（html5） --%>
                                    <%-- 点击li之后获取a标签上的data-url的值，将a表的data-url设置给iframe的src --%>
                                    <%--  showAllRole：查询角色的servlet的路径  --%>
                                    <a data-url="showAllRole">角色列表</a>
                                </li>
                                <li class="list-group-item">
                                    <a>角色授权</a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">

                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a data-url="/user?methodType=showUser">用户列表</a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseFour" aria-expanded="false" aria-controls="collapseThree">
                                商品管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <%-- 二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a data-url="/product?type=show">商品列表</a>
                                </li>
                                <li class="list-group-item">
                                    <a data-url="/page/product/saveProduct.jsp">添加商品</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <%--<ul class="nav nav-pills nav-stacked">--%>
                <%--<li role="presentation" class="active">--%>
                <%--<!-- 在a标签上自定义属性，存储菜单的链接 -->--%>
                <%--<a href="#" data-url="0.入门.html">首页</a>--%>
                <%--</li>--%>
                <%--<li role="presentation">--%>
                <%--<a href="#" data-url="3.表格.html">菜单管理</a>--%>
                <%--</li>--%>
                <%--<li role="presentation">--%>
                <%--<a href="#" data-url="4.表单.html">角色管理</a>--%>
                <%--</li>--%>
                <%--</ul>--%>
            </div>
        </div>
        <%--  内容 --%>
        <div class="col-md-8">
            <iframe id="main" src="page/hello.html" width="850px" height="1200px"
                    style=" padding: 5px; border: none;"></iframe>
        </div>

    </div>

    <script type="text/javascript">
        $(function () {
            $(".list-group-item").click(function () {
                // 获取a标签中的data-url
                var dataUrl = $(this).children("a").attr("data-url");
                // 将a标签的data-url赋值iframe
                $("#main").attr("src", dataUrl);
            });
        })
    </script>


</body>
</html>
