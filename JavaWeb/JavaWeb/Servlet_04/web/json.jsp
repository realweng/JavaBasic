<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        // json数据格式：{key:value}
        var user = {"name": "admin"};
        // 获取json中的数据
        console.log(user.name);

        user = {"name": "admin", "pwd": "123", "age": 18, "sex": "男"};
        console.log(user);
        console.log(user.name + "," + user.pwd + "," + user.age + "," + user.sex);

        user = {
            "name": "admin", "pwd": "123", "age": 18, "sex": "男",
            address: ["湖北武汉", "湖北黄石", "湖北黄冈"]
        }
        console.log(user);
        console.log(user.name + "," + user.pwd + "," + user.age + "," + user.sex + "," + user.address);

        user = [{
            "name": "admin", "pwd": "123", "age": 18, "sex": "男",
            address: ["湖北武汉", "湖北黄石", "湖北黄冈"]
        }, {
            "name": "小白", "pwd": "123", "age": 18, "sex": "男",
            address: ["湖南长沙", "湖南永州", "湖南郴州"]
        }, {
            "name": "小黄", "pwd": "123", "age": 18, "sex": "男",
            address: ["河南郑州", "河南开封", "河南洛阳"]
        }];
        console.log(user);
        user.forEach(function (value, index) {
            console.log(index + "," + value + ":" + value.name + "," + value.pwd);
        })
    </script>
</head>
<body>

</body>
</html>
