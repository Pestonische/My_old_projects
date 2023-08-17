<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate</title>
    </head>
    <body>
        <form action="calculate" method="post">
            First number<input type="number" name="first" required>
            Second number<input type="number" name="second" required>
            Operation<input name="operation" required>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
