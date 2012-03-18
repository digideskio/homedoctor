<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>Registration form</h1>
        <form:form commandName="user" action="register" method="POST">
            First name: <form:input path="firstName" /><form:errors path="firstName" /><br/>
            Last name: <form:input path="lastName" /><form:errors path="lastName" /><br/>
            <br/>
            Address:<br/>
            City: <form:input path="city" /><form:errors path="city" /><br/>
            Street address: <form:input path="streetAddress" /><form:errors path="streetAddress" /><br/>
            <br/>
            Phone number: <form:input path="phoneNumber" /><form:errors path="phoneNumber" /><br/>
            <br/>
            Date of Birth (dd mm yyyy): 
            <form:input path="dayBorn" maxlength="2" size="1"/> 
            <form:input path="monthBorn" maxlength="2" size="1"/> 
            <form:input path="yearBorn" maxlength="4" size="3"/> <br/>
            <form:errors path="dayBorn" /> <form:errors path="monthBorn" /> <form:errors path="yearBorn" /><br/>
            Choose password (6-15 characters): <form:password path="password" /><form:errors path="password" /><br/>
            
            <input type="submit" value="Send">
        </form:form>                
    </body>
</html>
