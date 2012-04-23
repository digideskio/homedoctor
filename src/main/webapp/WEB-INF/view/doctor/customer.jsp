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
        <h1>Customer:</h1>
        Name: ${customer.lastName} ${customer.firstName}<br/>
        Address: ${customer.streetAddress}, ${customer.city}<br/>
        Phone number: ${customer.phoneNumber}<br/>
        <h2>Past Reservations:</h2>
        <c:forEach var="reservation" items="${reservations}">
            ${reservation.orderDay}.${reservation.orderMonth}.${reservation.orderYear} at ${reservation.startHour}:00 
            <a href="../reservation/${reservation.id}">Show details</a> 
            <c:if test="${ not empty reservation.report}"><a href="../report/${reservation.report.id}">Show report</a></c:if>
            <c:if test="${ empty reservation.report && reservation.doctor.id == myId}"><a href="../newreport/${reservation.id}">Write report</a></c:if>
            <br/>
        </c:forEach>
        <br/>
        <a href="../home">back to home</a>
        <a href="../mycustomers">back to my customers</a>
    </body>
</html>

