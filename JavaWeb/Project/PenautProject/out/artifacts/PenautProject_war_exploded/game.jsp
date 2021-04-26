<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8"/>
    <link rel="shortcut icon" href="#"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <!-- ajaxfileupload.js文件请复制项目中的，外面的js文件有bug!!! -->
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        $("#gameIcon").change(function () {
            console.log("aaa");
            $.ajaxFileUpload({
                url: "gameServlet.do?type=fileGame",
                fileElementId: "gameIcon",
                dataType: "text",
                success: function (data) {
                    console.log(data);
                    $("#gameIcons").val(data);
                },
                error: function () {
                    alert("error");
                }
            });
        });
        $("#gameDetails").change(function () {
            $.ajaxFileUpload({
                url: "gameServlet.do?type=fileGame",
                fileElementId: "gameDetails",
                dataType: "text",
                success: function (data) {
                    console.log(data);
                    $("#gameDetailss").val(data);
                },
                error: function () {
                    alert("error");
                }
            });
        });
        $("#iosUrl").change(function () {
            $.ajaxFileUpload({
                url: "gameServlet.do?type=fileGame",
                fileElementId: "iosUrl",
                dataType: "text",
                success: function (data) {
                    console.log(data);
                    $("#iosUrls").val(data);
                },
                error: function () {
                    alert("error");
                }
            });
        });
        $("#androidUrl").change(function () {
            $.ajaxFileUpload({
                url: "gameServlet.do?type=fileGame",
                fileElementId: "androidUrl",
                dataType: "text",
                success: function (data) {
                    console.log(data);
                    $("#androidUrls").val(data);
                },
                error: function () {
                    alert("error");
                }
            });
        });
    });

    function topage(currentpage) {
        var form = document.forms[0];
        form.currentpage.value = currentpage;
        form.submit();
    }


    function check() {
        var name = $("#gameName").val();
        var gameTitle = $("#gameTitle").val();
        var gameSize = $("#gameSize").val();
        if (gameName == "" || gameTitle == "" || gameSize == "") {
            alert("信息未填写完整，请完善！");
            return false;
        }
    }
</script>
<body>
<form>
    <div class="container">

        <div class="row">
            <div>
                <input type="hidden" id="countPage">
                <table id="showGame" class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <td colspan="10">
                            <a class="btn btn-success" data-toggle="modal" data-target="#addGame">添加游戏</a>
                        </td>
                    </tr>
                    <tr>
                        <th>序号</th>
                        <th>名称</th>
                        <th>标题</th>
                        <th>下载量</th>
                        <th>大小(M)</th>
                        <th>状态</th>
                        <th>分类</th>
                        <th>平台类型</th>
                        <th>推荐类型</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${game}" var="game">
                        <tr>
                            <td> ${game.gameId} </td>
                            <td><a href="gameServlet.do?type=countGame&gameId=${game.gameId}">${game.gameName}</a></td>
                            <td> ${game.gameTitle} </td>
                            <td> ${game.gameDownloads} </td>
                            <td> ${game.gameSize} </td>
                            <td> ${game.state==1?"启用":"未启用"} </td>
                            <td> ${game.typeName} </td>
                            <td> ${game.gamePlatformType==1?"安卓":"苹果"} </td>
                            <td> ${game.gameRecommendType==1?"普通":"首页推荐"} </td>
                            <td>
                                <a href="gameServlet.do?type=updateGame&gameId=${game.gameId}"
                                    <%--"<script>alert('登录失败!');window.location.href=gameServlet.do?type=queryGame'</script>"--%>
                                <button type="button" class="btn btn-primary btn-xs" id="update">修改</button>
                                </a>
                                <a href="gameServlet.do?type=deleteGame&gameId=${game.gameId}">
                                    <button type="button" class="btn btn-danger btn-xs"> 删除</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<div class="row">
    <!-- 添加数据 -->
    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         id="addGame">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <!-- 头部 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" aria-label="Close">x</button>
                    <h2>添加游戏</h2>
                </div>
                <div class="modal-body">
                    <!-- 表单（录入英雄信息） -->
                    <form action="gameServlet.do?type=addGame" method="post" enctype="multipart/form-data"
                          class="form-horizontal" style="padding-right: 120px;" id="myFro">
                        <div class="form-group row">
                            <label class="control-label col-md-4">游戏名称：</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="gameName" id="gameName"
                                       placeholder="游戏名称"
                                       required="required"/>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">游戏标题：</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="gameTitle" id="gameTitle"
                                       placeholder="游戏标题" required="required"/>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">游戏大小(单位M)：</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="gameSize" id="gameSize"
                                       placeholder="游戏大小"
                                       required="required"/>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">游戏图标：</label>
                            <div class="col-md-7">
                                <input type="file" class="form-control" name="gameIcon" id="gameIcon"
                                       placeholder="游戏图标" required="required"/>
                                <input type="hidden" id="gameIcons" name="gameIcons">
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">游戏详情图片：</label>
                            <div class="col-md-7">
                                <input type="file" class="form-control" name="gameDetails" id="gameDetails"
                                       placeholder="游戏详情图片"/>
                                <input type="hidden" id="gameDetailss" name="gameDetailss">
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">ios下载地址：</label>
                            <div class="col-md-7">
                                <input type="file" class="form-control" name="iosUrl" id="iosUrl"
                                       placeholder="ios下载地址"/>
                                <input type="hidden" id="iosUrls" name="iosUrls">
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">android下载地址：</label>
                            <div class="col-md-7">
                                <input type="file" class="form-control" name="androidUrl" id="androidUrl"
                                       placeholder="android下载地址"/>
                                <input type="hidden" id="androidUrls" name="androidUrls">
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">推荐类型：</label>
                            <div class="col-md-7">
                                <select class="form-control" name="gameRecommendType" id="gameRecommendType">
                                    <option value="1">普通</option>
                                    <option value="2">首页推荐</option>
                                </select>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">状态：</label>
                            <div class="col-md-7">
                                <select class="form-control" name="state" id="state">
                                    <option value="1">启用</option>
                                    <option value="0">未启用</option>
                                </select>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">游戏分类：</label>
                            <div class="col-md-7">
                                <select class="form-control" name="gameClassify" id="gameClassify">
                                    <option value="1">休闲益智</option>
                                    <option value="2">网络游戏</option>
                                    <option value="3">动作冒险</option>
                                    <option value="4">棋牌中心</option>
                                    <option value="5">飞行射击</option>
                                    <option value="6">经营策略</option>
                                    <option value="7">角色扮演</option>
                                    <option value="8">体育竞技</option>
                                </select>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">平台类型：</label>
                            <div class="col-md-7">
                                <select class="form-control" name="gamePlatformType" id="gamePlatformType">
                                    <option value="1">android</option>
                                    <option value="2">ios</option>
                                </select>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">平台类型：</label>
                            <div class="col-md-7">
                                游戏描述
                                <textarea class="form-control" name="gameOver" rows="1"
                                          style="width: 400px; height: 81px;"></textarea>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <!-- 脚部 -->
                        <div class="modal-footer">
                            <button type="submit" id="addButton" class="btn btn-primary">添加</button>
                            <button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>