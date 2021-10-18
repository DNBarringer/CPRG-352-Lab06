<%-- 
    Document   : register
    Created on : 17-Oct-2021, 4:06:26 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form name="loginForm" method="post" action="ShoppingList">
            <label for="login_username">Username: </label><input type="text" id="login_username" name="loginInfo[]">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register Name">
        </form>
        <h2>${message}</h2>
    </body>
</html>
