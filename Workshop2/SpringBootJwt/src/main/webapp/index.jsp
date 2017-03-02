<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Artikelen</h1>
            <table>
                <tr>
                    <th>Naam</th>
                    <th>Prijs</th>
                    <th>Aantal op voorraad</th>
                </tr>
                <c:forEach items="${artikelen}" var="artikel">
                    <tr>
                        <td><c:out value="${artikel.naam}"/></td>
                        <td><c:out value="${artikel.prijs}"/></td>
                        <td><c:out value="${artikel.voorraad}"/></td>
                    </tr>
                </c:forEach>
            </table>
        <h1>Log in</h1>
        <form method="POST" action="login">
            Username: <input type="text" name="username" value=""/><br>
            Wachtwoord: <input type="password" name="password" value=""/><br>
            <input type="submit" value="Log in"/>
        </form>
    </body>
</html>
