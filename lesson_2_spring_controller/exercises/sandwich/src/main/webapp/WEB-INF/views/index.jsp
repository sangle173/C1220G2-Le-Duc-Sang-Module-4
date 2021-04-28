<%--
  Created by IntelliJ IDEA.
  User: SANG
  Date: 4/26/2021
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Sandwich Condiments</h1><br>
<form action="/save" method="get">
    <table>
        <tr>
            <td><input type="checkbox" name="condiment" value="Lettuce"> Lettuce</td>
            <td><input type="checkbox" name="condiment" value="Tomato"> Tomato</td>
            <td><input type="checkbox" name="condiment" value="Mustard"> Mustard</td>
            <td><input type="checkbox" name="condiment" value="Sprouts"> Sprouts</td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Save">
</form>
<br>
<c:if test="${condiments != null}">
    <h4> ${message}</h4><br>
    <h4>Sandwich condiments:
        <c:forEach items="${condiments}" var="condiment">
            <c:out value=" ${condiment} "></c:out>
        </c:forEach>
    </h4>
</c:if>
</body>
</html>
