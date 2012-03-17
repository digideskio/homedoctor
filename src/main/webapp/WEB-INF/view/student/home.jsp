<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Le home de student.</h1>
        <h2>Update your information</h2>
        <form action="update" method="POST">
            Name: <input type="text" name="name" value="${user.name}"/><br />
            Username: ${user.username} <input type="hidden" name="username" value="${user.username}"/><br />
            Password: <input type="password" name="password" value="${user.password}"/><br />
            <input type="submit" value="Update" />
        </form>
        <p><a href="${pageContext.request.contextPath}/home" > Back</a></p>            
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
