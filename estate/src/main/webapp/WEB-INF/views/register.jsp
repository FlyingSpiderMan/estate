<%--
  Created by IntelliJ IDEA.
  User: 岳春春
  Date: 2020/11/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.5.0.min.js"></script>
</head>
<body>
<div align="center">
    <div  id="di">
        <h2>账号注册</h2>
        <form method="post" action="/doregister.do">

            <p>身份证件：<input type="text" name="cardid"></p>
            <p>用户名：<input type="text" name="name"></p>
            <p>密码：<input type="password" name="password"></p>
            <p>确认密码：<input type="password" name="password2"></p>
            <p>
                <input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type=button value="后退" onclick="window.history.back()">
            </p>
        </form>

    </div>
</div>

<script>

    $(function(){
        $("form").submit(function () {
            var cardId = $("[name='cardid']").val();
            var name = $("[name='name']").val();
            var password = $("[name='password']").val();
            var password2 = $("[name='password2']").val();

            if (cardId == "") {
                alert("身份证必填！")
                return false;
            }
            if (name == "") {
                alert("用户名必填！")
                return false;
            }
            if (password == "") {
                alert("密码必填！")
                return false;
            }
            if (password.length < 6) {
                alert("密码不能小于6位")
                return false;
            }
            if (password2 != password) {
                alert("两次密码输入不一致")
                return false;
            }
            var flag = true;
            return true;
        })
    })


</script>
</body>
</html>
