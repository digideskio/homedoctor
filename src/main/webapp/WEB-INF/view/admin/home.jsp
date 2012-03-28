<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
        <p><a href="register">Register a new doctor.</a></p>
        <h2>Current doctors</h2>
        <ul>
            <c:forEach var="doc" items="${doctors}">
                <li>
                    ${doc.lastName} ${doc.firstName}
                </li>
            </c:forEach>
    </body>
</html>
