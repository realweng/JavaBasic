<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/14
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getContextPath();%>
<html>
<head>
    <title>注册</title>
    <script src="/static/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<script>
    function sendSms() {
        //发送短信.短信发送成功获取状态.
        //成功则禁用发送按钮,按钮文案改为倒计时
        //倒计时结束,按钮回复重新发送

        var phone = $("input[name='phone']").val(); //获取手机输入框的值
        if (phone == '') {
            alert("请填写手机号码!");
            return;
        }
        //请求验证码
        $.post("<%=basePath%>/register/getCode", {phone: phone},
            function (data) {
                console.log(data);
            });
        //获取获取验证码按钮
        var sendSmsBtn = $("button[id='sendSmsBtn']");
        sendSmsBtn.attr("disabled", "") //设置为禁用
        timeout(); //调用倒计时
    }

    var time = 60; //倒计时时间
    function timeout() {
        var sendSmsBtn = $("button[id='sendSmsBtn']");
        if (time > 0) { //倒计时中
            sendSmsBtn.html("倒计时:" + time)
            time--;
            setTimeout(function () {
                timeout();
            }, 1000);
        } else { //倒计时结束
            sendSmsBtn.html("重新发送");
            sendSmsBtn.removeAttr("disabled");
            time = 60; //重置倒计时时间
        }
    }

    /**
     * 校验表单
     */
    function checkForm() {
        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();
        var phone = $("input[name='phone']").val();
        var code = $("input[name='code']").val();
        if (username == '' || password == '' ||  phone == '' ||  code == '') {
            alert("必填项不能为空!");
            return false;
        }
    }
</script>
<form action="<%=basePath%>/register" method="post" onsubmit="return checkForm()">
    用户名:<input name="username"><br>
    密码:<input name="password"><br>
    手机:<input name="phone">
    <button id="sendSmsBtn" type="button" onclick="sendSms()">获取验证码</button>
    <br>
    验证码:<input name="code"><br>
    <button>注册</button>
</form>
</body>
</html>
