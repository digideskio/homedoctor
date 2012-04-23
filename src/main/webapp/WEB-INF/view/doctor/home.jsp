<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>Hello Doctor!</h1>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
        <br/>
        
        <h2>Upcoming reservations:</h2>
        <ul>
        <c:forEach var="res" items="${futureReservations}">
            <li>
                <ul>
                    <li>Date and time: ${res.orderDay}.${res.orderMonth}.${res.orderYear} at ${res.startHour}:00</li>
                    <li>Customer: ${res.customer.lastName} ${res.customer.firstName}</li>
                    <li><a href="reservation/${res.id}">Show details</a></li>
                </ul>
            </li>
            <br/>
        </c:forEach>
        </ul>
        <a href="history">Show reservation history</a>
        <a href="mycustomers">Show my customers</a>
    </body>
</html>
