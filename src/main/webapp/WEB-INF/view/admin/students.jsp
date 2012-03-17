<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new student</h1>
        <form action="students" method="POST">
            Name <input type="text" name="name" /><br />
            Username <input type="text" name="username" /><br />
            Password <input type="password" name="password" value="vaihda"/><br />
            <input type="submit" value="Create user" />
        </form>
    </body>
</html>
