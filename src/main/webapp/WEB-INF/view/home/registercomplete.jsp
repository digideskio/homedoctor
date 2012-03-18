<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MediHome</title>
    </head>
    <body>
        <h1>Registration completed</h1>
        <p>Your customer number is ${customerNumber}. Please remember it. You will use it to log in.</p>
        <p>Thank you for using our service.</p>
        <p>Now you can <a href="login">login</a>.</p>
    </body>
</html>
