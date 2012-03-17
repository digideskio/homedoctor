<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new course</h1>
        <form action="courses" method="POST">
            Name <input type="text" name="coursename" /><br />
            <input type="submit" value="Create user" />
        </form>
    </body>
</html>
