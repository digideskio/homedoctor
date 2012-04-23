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
        <h1>Reservation history</h1>
        <c:forEach var="reservation" items="${reservations}">
            ${reservation.orderDay}.${reservation.orderMonth}.${reservation.orderYear} at ${reservation.startHour}:00 for 
            ${reservation.customer.lastName} ${reservation.customer.firstName}. 
            <a href="reservation/${reservation.id}">Show details</a> 
            <c:if test="${ not empty reservation.report}"><a href="report/${reservation.report.id}">Show report</a><br/></c:if>
            <c:if test="${ empty reservation.report}"><a href="newreport/${reservation.id}">Write report</a><br/></c:if>
        </c:forEach>
        <br/>
        <a href="home">back to home</a>
    </body>
</html>
