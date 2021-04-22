<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/19
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="style/jquery.cleditor.css">
<!-- Uniform -->
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="style/bootstrap-switch.css">
<!-- Main stylesheet -->
<link href="style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="style/widgets.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- ajaxfileupload.js文件请复制项目中的，外面的js文件有bug!!! -->
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
    $(function () {
        $("#gameIcon").change(function () {
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
    })
</script>
<body>
<!-- 表单（录入英雄信息） -->
<div>
    <form action="gameServlet.do?type=update&gameId=${game.gameId}" method="post"
          class="form-horizontal" role="form" style="margin: auto;padding-left: 550px;">
        <div>
            <h2 name="gameId">修改游戏序号为：${game.gameId}</h2>
        </div>
        <br/>
        <div class="form-group row">
            <label class="control-label col-md-4">游戏名称：</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="gameName" id="gameName"
                       placeholder="游戏名称"
                       required="required"/>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">游戏标题：</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="gameTitle" id="gameTitle"
                       placeholder="游戏标题" required="required"/>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">游戏大小(单位M)：</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="gameSize" id="gameSize"
                       placeholder="游戏大小"
                       required="required"/>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">游戏图标：</label>
            <div class="col-md-4">
                <input type="file" class="form-control" name="gameIcon" id="gameIcon"
                       placeholder="游戏图标" required="required"/>
                <input type="hidden" id="gameIcons" name="gameIcons">
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">游戏详情图片：</label>
            <div class="col-md-4">
                <input type="file" class="form-control" name="gameDetails" id="gameDetails"
                       placeholder="游戏详情图片"/>
                <input type="hidden" id="gameDetailss" name="gameDetailss">

            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">ios下载地址：</label>
            <div class="col-md-4">
                <input type="file" class="form-control" name="iosUrl" id="iosUrl"
                       placeholder="ios下载地址"/>
                <input type="hidden" id="iosUrls" name="iosUrls">

            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">android下载地址：</label>
            <div class="col-md-4">
                <input type="file" class="form-control" name="androidUrl" id="androidUrl"
                       placeholder="android下载地址"/>
                <input type="hidden" id="androidUrls" name="androidUrls">

            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">推荐类型：</label>
            <div class="col-md-4">
                <select class="form-control" name="gameRecommendType" id="gameRecommendType">
                    <option value="1">普通</option>
                    <option value="2">首页推荐</option>

                </select>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">状态：</label>
            <div class="col-md-4">
                <select class="form-control" name="state" id="state">
                    <option value="1">启用</option>
                    <option value="0">未启用</option>
                </select>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">游戏分类：</label>
            <div class="col-md-4">
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
            <div class="col-md-4">
                <select class="form-control" name="gamePlatformType" id="gamePlatformType">
                    <option value="1">android</option>
                    <option value="2">ios</option>
                </select>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-4">平台类型：</label>
            <div class="col-md-4">
                游戏描述
                <textarea class="form-control" name="gameOver" id="gameOver" rows="1"
                          style="width: 300px; height: 81px;"></textarea>
            </div>
            <div class="col-md-1"></div>
        </div>
        <!-- 脚部 -->
        <div style="padding-left: 200px">
            <button type="submit" id="addButton" class="btn btn-primary">修改</button>
            <button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
        </div>
    </form>
</div>
</body>
<%--<!-- JS -->--%>
<%--<script src="js/jquery.js"></script> <!-- jQuery -->--%>
<%--<script src="js/bootstrap.js"></script> <!-- Bootstrap -->--%>
<%--<script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->--%>
<%--<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->--%>
<%--<script src="js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->--%>
<%--<script src="js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->--%>

<%--<!-- jQuery Flot -->--%>
<%--<script src="js/excanvas.min.js"></script>--%>
<%--<script src="js/jquery.flot.js"></script>--%>
<%--<script src="js/jquery.flot.resize.js"></script>--%>
<%--<script src="js/jquery.flot.pie.js"></script>--%>
<%--<script src="js/jquery.flot.stack.js"></script>--%>

<%--<!-- jQuery Notification - Noty -->--%>
<%--<script src="js/jquery.noty.js"></script> <!-- jQuery Notify -->--%>
<%--<script src="js/themes/default.js"></script> <!-- jQuery Notify -->--%>
<%--<script src="js/layouts/bottom.js"></script> <!-- jQuery Notify -->--%>
<%--<script src="js/layouts/topRight.js"></script> <!-- jQuery Notify -->--%>
<%--<script src="js/layouts/top.js"></script> <!-- jQuery Notify -->--%>
<%--<!-- jQuery Notification ends -->--%>

<%--<script src="js/sparklines.js"></script> <!-- Sparklines -->--%>
<%--<script src="js/jquery.cleditor.min.js"></script> <!-- CLEditor -->--%>
<%--<script src="js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->--%>
<%--<script src="js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->--%>
<%--<script src="js/filter.js"></script> <!-- Filter for support page -->--%>
<%--<script src="js/custom.js"></script> <!-- Custom codes -->--%>
<%--<script src="js/charts.js"></script> <!-- Charts & Graphs -->--%>
</html>
