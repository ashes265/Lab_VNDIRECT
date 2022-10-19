<%--
  Created by IntelliJ IDEA.
  User: phung
  Date: 9/30/2022
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" import="java.io" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%
    Exception exp=(Exception) request.getAttribute("javax.servlet.error.exception");
    exp.printStackTrace(response.getWriter());
%>
</body>
</html>
