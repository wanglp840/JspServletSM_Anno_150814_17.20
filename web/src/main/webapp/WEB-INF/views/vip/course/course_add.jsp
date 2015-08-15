<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

Hello,${userLoginName} <br>
您的userId是:${userId}


<br><br><br>


新增课程：
<form action="/vip/course/new/${userId}" method="POST">

    课程名 <input name="courseName">

    <button type="submit">
        提交
    </button>
    <br>


</form>

</body>
</html>