<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>New doctor</h1>
        <form:form commandName="user" action="register" method="POST">
            First name: <form:input path="firstName" /><form:errors path="firstName" /><br/>
            Last name: <form:input path="lastName" /><form:errors path="lastName" /><br/>
            Choose a username (4-15 characters): <form:password path="username" /><form:errors path="username" /><br/>
            Choose password (6-15 characters): <form:password path="password" /><form:errors path="password" /><br/>
            <input type="submit" value="Done">
        </form:form>                
    </body>
</html>
