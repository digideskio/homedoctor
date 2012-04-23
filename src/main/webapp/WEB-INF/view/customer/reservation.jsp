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
        <form:form commandName="reservation" action="reservation" method="POST">
            Choose a free time: <form:select path="startHour" items="${freetimes}" />:00 <form:errors path="startHour" /><br/><br/>
            Shortly describe your symptoms and give other info: <br/>
            <form:textarea path="message" /> <form:errors path="message" />
            <form:hidden path="day"/>
            <form:hidden path="month"/>
            <form:hidden path="year"/>
            <form:hidden path="doctorId"/>
            
            <input type="submit" value="Send">
        </form:form>
    </body>
</html>
