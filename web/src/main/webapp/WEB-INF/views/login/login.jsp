<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

${loginErrInfo} <br>

登录：
<form action="/do/login" method="POST">
    用户名
    <input name="userName">
    密码
    <input name="password"/>
    <button type="submit" name="action" value="login">
        提交
    </button>
    <br>


</form>

</body>
</html>