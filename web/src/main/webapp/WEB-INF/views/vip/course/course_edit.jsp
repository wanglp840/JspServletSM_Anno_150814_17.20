<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

courseId:${course.courseId}<br>
userId:${user.id}
<br><br>

编辑课程：
<form action="/vip/course/edit/${course.courseId}" method="POST">
    课程名
    <input name="courseName" name="courseName" value="${course.courseName}">


    <button type="submit">
        提交
    </button>


</form>

</body>
</html>