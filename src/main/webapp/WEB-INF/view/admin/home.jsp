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
        <h1>Le home de admin.</h1>
        <sec:authorize access="hasRole('lecturer')"><p><a href="students" />Add new student</a></p></sec:authorize>
        <sec:authorize access="hasRole('lecturer')"><p><a href="courses" />Add new course</a></p></sec:authorize>
        <p><a href="${pageContext.request.contextPath}/home" > Back</a></p>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
