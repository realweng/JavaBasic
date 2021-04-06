<%--
    json jsp ajax 级联
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/3
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 查询所有省份(ajax)
            $.get("getArea", "type=getProvince", function (data) {
                console.log(data);
                data.forEach(function (value, index) {// value:地址对象
                    // 创建option对象
                    var $option = $("<option value='" + value.areaId + "'>" + value.areaName + "</option>");
                    // 将option追加到select（id=province）
                    $("#province").append($option);
                })
            }, "json");

            //    给省份绑定事件，通过省ID查询市
            $("#province").change(function () {
                // 获取省ID
                var id = $(this).val();
                $("#city").children("option:not(:first)").remove();
                $("#district").children("option:not(:first)").remove();
                if (id != "0") {
                    // 使用ajax发送请求到服务器
                    $.get("getArea", "type=getCity&id=" + id, function (data) {
                        $(data).each(function (index, obj) {
                            var $option = $("<option value='" + obj.areaId + "'>" + obj.areaName + "</option>");
                            $("#city").append($option);
                        })
                    }, "json");
                }
            });

            // 给市绑定事件，通过市ID查询区
            $("#city").change(function () {
                // 获取市ID
                var id = $(this).val();
                $("#district").children("option:not(:first)").remove();
                if (id != "0") {
                    // 使用ajax发送请求到服务器
                    $.get("getArea", "type=getDistrict&id=" + id, function (data) {
                        $(data).each(function (index, obj) {
                            var $option = $("<option value='" + obj.areaId + "'>" + obj.areaName + "</option>");
                            $("#district").append($option);
                        })
                    }, "json");
                }
            });
        })
    </script>
</head>
<body>
<select name="province" id="province">
    <option value="0">-- 请选择 --</option>
</select>
<select name="city" id="city">
    <option value="0">-- 请选择 --</option>
</select>
<select name="district" id="district">
    <option value="0">-- 请选择 --</option>
</select>
</body>
</html>
