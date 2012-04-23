<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>My customers</h1>
        <c:forEach var="customer" items="${customers}">
            <a href="customer/${customer.id}">${customer.lastName} ${customer.firstName}</a> <br/>
        </c:forEach>
        <br/>
        <a href="home">back to home</a>
    </body>
</html>
