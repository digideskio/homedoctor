<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Le home de casual person.</h1>
        <p><a href="student/home">Le home de student!</a></p>
        <p><a href="admin/home">Le home de admin!</a></p>

        <h2>Le Students</h2>
        <ul>
            <c:forEach var="student" items="${students}" >
                <li>${student.name} <sec:authorize access="hasRole('lecturer')">(username: ${student.username})</sec:authorize></li>
            </c:forEach>
        </ul>
        <h2>Le Courses</h2>
        <ul>
            <c:forEach var="course" items="${courses}" >
                <li>
                    ${course.coursename} (${course.size} students) 
                    <sec:authorize access="hasRole('student')"><a href="join/${course.id}">Register</a></sec:authorize>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
