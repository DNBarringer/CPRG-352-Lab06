<%-- 
    Document   : shoppingList
    Created on : 17-Oct-2021, 4:06:47 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${s_username} <a href="ShoppingList?action=logout">Log out</a></p>
        
        <form action="" method="post">
            <h2>Add Item</h2>
            <input type="text" name="itemToAdd"><input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
            <form action="" method="post">

                <ul>
                    <c:forEach items="${myShoppingList}" var="listItem">
                        <li><input type="radio" name="item" value="${listItem}">${listItem}</li>
                    </c:forEach>
                </ul>

                    <input type="submit" value="Delete">
                    <input type="hidden" name="action" value="delete">
            </form>
    </body>
</html>
