<%--
  Created by IntelliJ IDEA.
  User: phung
  Date: 9/29/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="students/saveOrUpdate" method="post">
    Student name: <form:input path="name"/><br/>
    Age: <form:input path="age"/>

</form:form>
</body>
</html>
