<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>


请输入注册信息：
<form action="/do/register" method="POST">

    用户名
    <input name="userName">
    密码
    <input name="password"/>
    <button type="submit" name="action" value="register">
        提交
    </button>
</form>


<br><br><br><br>

<!--登录成功提示-->
${loginSucStr}



<br><br><br>
<a href="/login">去登录吧</a>

</body>
</html>