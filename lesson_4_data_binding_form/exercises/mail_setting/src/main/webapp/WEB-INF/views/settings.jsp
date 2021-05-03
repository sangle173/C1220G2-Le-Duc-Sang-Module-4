<%--
  Created by IntelliJ IDEA.
  User: SANG
  Date: 5/3/2021
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="mailSetting" action="../settings/save" method="post">
    <table>
        <tr>
            <td>
                <label for="language">Languages</label>
            </td>
            <td>
                <form:select path="language" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="pageSize">Page Size:</label>
            </td>
            <td>
                <p>Show <form:select path="pageSize" items="${pageSizes}"/> emails per page</p>
            </td>
        </tr>
        <tr>
            <td>
               <%--@declare id="spamsfilter"--%><label for="spamsFilter">Spams Filter:</label>
            </td>
            <td>
                <form:checkbox path="spamsFilter"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                <label for="signature">Signature:</label>
            </td>
            <td>
                <form:textarea path="signature" rows="3"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
                <a href="../"><input type="button" value="Cancel"></a>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>${message}
        </tr>
    </table>
</form:form>
</body>
</html>
