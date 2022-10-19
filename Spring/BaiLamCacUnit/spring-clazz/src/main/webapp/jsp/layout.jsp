<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">

    <tr>
        <td height="30">Welcome to Java Spring Clazz
        </td>
    </tr>
    <tr>
        <td height="30">
            <a href="/">Trang chu</a>
            <sec:authorize access="!hasAnyRole('ROLE_USER')">
                <a href="/login" style="margin-left: 30px">Login</a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <a href="/nguoi-dung" style="margin-left: 30px">Login</a>
                <a href="/logout" style="margin-left: 30px">Logout</a>
            </sec:authorize>
        </td>
    </tr>
    <tr>
        <td><tiles:insertAttribute name="body"/></td>
    </tr>

</table>
</body>
</html>