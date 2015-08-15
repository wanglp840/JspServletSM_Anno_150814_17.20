<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

登陆成功, userId:${user.id} 姓名：${user.userName} <br>

sessionTest:<br>
SessionId:${pageContext.session.getId()}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br><br>

<table>
    <form action="" method="get">
        <tr>
            <td>课程id&nbsp;&nbsp;&nbsp;</td>
            <td>课程名称&nbsp;&nbsp;&nbsp;</td>
            &nbsp;
            <td>操作&nbsp;&nbsp;&nbsp;</td>



            <li>
                <a href="/vip/course/new/${user.id}">
                    <span class="fa fa-group"></span>
                    增加课程
                </a>
            </li>

        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>

                    <a href="/vip/course/del/${course.courseId}" >
                        <span class="fa fa-group"></span>
                        del
                    </a>
                </td>
                <td>
                    <a href="/vip/course/edit/${course.courseId}">edit</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>