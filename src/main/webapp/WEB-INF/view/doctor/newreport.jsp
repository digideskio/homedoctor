<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>New report</h1>
        <form:form commandName="report" action="" method="POST">
            Report: <br/>
            <form:textarea path="report" /> <form:errors path="report" /><br/>
            Treatment instructions: <br/>
            <form:textarea path="treatmentInstructions" /> <form:errors path="treatmentInstructions" /><br/>
            
            <input type="submit" value="Send">
        </form:form>
    </body>
</html>
