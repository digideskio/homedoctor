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
        <h1>Report</h1>
        <br/>
        <c:set var="message" value="${report.report}" />
        <%pageContext.setAttribute("message", ((String) pageContext.getAttribute("message")).replaceAll("\r\n", "<br />"));%>
        <c:out value="${message}" escapeXml="false" />
        <br/>
        <h3>Treatment instructions</h3>
        <c:set var="message" value="${report.treatmentInstructions}" />
        <%pageContext.setAttribute("message", ((String) pageContext.getAttribute("message")).replaceAll("\r\n", "<br />"));%>
        <c:out value="${message}" escapeXml="false" />
        <br/><br/>
        move to:<br/>
        <a href="../home">home</a><br/>
        <a href="../reservations">my reservations</a><br/>
    </body>
</html>

