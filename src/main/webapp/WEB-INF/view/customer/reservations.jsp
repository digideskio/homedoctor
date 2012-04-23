<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>Your reservations</h1>
        <br/>
        <h2>Upcoming:</h2>
        <ul>
            <c:forEach var="reservation" items="${futureReservations}">
                <li>${reservation.orderDay}.${reservation.orderMonth}.${reservation.orderYear} at ${reservation.startHour}:00 
                    for Doctor ${reservation.doctor.lastName} ${reservation.doctor.firstName} - 
                    <a href="cancel/${reservation.id}">cancel</a>
                </li>
            </c:forEach>
        </ul>
        <br/>
        <h2>Past:</h2>
        <ul>
            <c:forEach var="reservation" items="${pastReservations}">
                <li>${reservation.orderDay}.${reservation.orderMonth}.${reservation.orderYear} at ${reservation.startHour}:00 
                    for Doctor ${reservation.doctor.lastName} ${reservation.doctor.firstName} 
                    <c:if test="${ not empty reservation.report}"><a href="report/${reservation.id}">Show report</a></c:if>
                </li>
            </c:forEach>
        </ul>
        <br/>
        
        <a href="home">back to home page</a>
    </body>
</html>
