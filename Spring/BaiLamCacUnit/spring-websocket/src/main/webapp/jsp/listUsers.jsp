<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List User</title>
</head>
<body onload="connect()">
<h1>User List</h1>

<table border="1" style="width: 80%;margin: auto">
    <tr>
        <td>Name</td>
        <td>Action</td>
    </tr>

    <c:forEach items="${users}" var="it" varStatus="loop">
        <tr>
            <td>
                <a href="/user/detail/${it.username}">${it.username} - age: ${it.age}</a>
            </td>
            <td><a href="/user/delete/${it.username}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>