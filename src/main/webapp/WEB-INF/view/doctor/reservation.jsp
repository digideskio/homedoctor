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
        <h1>Reservation</h1>
        <h2>${reservation.orderDay}.${reservation.orderMonth}.${reservation.orderYear} at ${reservation.startHour}:00</h2>
        <h2>Doctor:</h2> ${reservation.doctor.lastName} ${reservation.doctor.firstName}
        <h2>Customer:</h2>
        Name: ${reservation.customer.lastName} ${reservation.customer.firstName}<br/>
        Address: ${reservation.customer.streetAddress}, ${reservation.customer.city}<br/>
        Phone number: ${reservation.customer.phoneNumber}<br/>
        <h2>Symptoms and other information:</h2>
        <c:set var="message" value="${reservation.message}" />
        <%pageContext.setAttribute("message", ((String) pageContext.getAttribute("message")).replaceAll("\r\n", "<br />"));%>
        <c:out value="${message}" escapeXml="false" />
    </body>
</html>

