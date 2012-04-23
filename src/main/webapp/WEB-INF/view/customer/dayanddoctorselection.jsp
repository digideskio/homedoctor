<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>New reservation</h1>
        <h2>Choose day and doctor</h2>
        <form:form commandName="formobj" action="dayanddoctorselection" method="POST">
            Year: <form:input path="year" /><form:errors path="year" /><br/>
            Month: <form:input path="month" /><form:errors path="month" /><br/>
            Day: <form:input path="day" /><form:errors path="day" /><br/>
            Doctor: 
            <form:select path="doctor">
                <c:forEach items="${doctors}" var="doc">
                    <form:option value="${doc.id}">${doc.lastName} ${doc.firstName}</form:option>
                </c:forEach>
            </form:select>
            <input type="submit" value="Continue">
        </form:form>                
    </body>
</html>
